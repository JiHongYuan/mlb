package com.github.mlb.dms.listener;

import com.github.mlb.common.model.BinlogDTO;
import com.github.mlb.dms.listener.handler.DeleteEventHandler;
import com.github.mlb.dms.listener.handler.UpdateEventHandler;
import com.github.mlb.dms.listener.handler.WriteEventHandler;
import com.github.mlb.dms.listener.model.RowsData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.TableMapEventData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JiHongYuan
 * @date 2021/9/20 6:59
 */
public class EventHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventHandlerAdapter.class);

    private final List<EventHandler> eventHandlerList = new ArrayList<>();
    private final Map<Long, TableMapEventData> tableEventDataMapCache = new HashMap<>(16);

    public EventHandlerAdapter() {
        eventHandlerList.add(new WriteEventHandler());
        eventHandlerList.add(new UpdateEventHandler());
        eventHandlerList.add(new DeleteEventHandler());
    }

    @Nullable
    public BinlogDTO handler(EventData eventData) {
        if (eventData == null) {
            return null;
        }

        // 缓存tableId 对应 tableData
        if (eventData instanceof TableMapEventData) {
            TableMapEventData mapEventData = (TableMapEventData) eventData;
            tableEventDataMapCache.put(mapEventData.getTableId(), mapEventData);
        }

        // 获取具体类型handler
        EventHandler eventHandler = getHandler(eventData);
        if (eventHandler == null) {
            throw new RuntimeException("can not find " + eventData.getClass() + " match handler");
        }

        RowsData rowsData = eventHandler.handler(eventData);
        String action = eventHandler.eventAction();

        TableMapEventData tableMapEventData = tableEventDataMapCache.get(rowsData.getTableId());
        BinlogDTO binlogDTO = new BinlogDTO();
        binlogDTO.setTableId(tableMapEventData.getTableId());
        binlogDTO.setDatabase(tableMapEventData.getDatabase());
        binlogDTO.setTable(tableMapEventData.getTable());
        binlogDTO.setEventAction(action);
        binlogDTO.setRows(rowsData.getRows());

        return binlogDTO;
    }

    @Nullable
    EventHandler getHandler(EventData eventData) {
        for (EventHandler eventHandler : eventHandlerList) {
            boolean support = eventHandler.support(eventData);
            if (support) {
                return eventHandler;
            }
        }
        return null;
    }

}