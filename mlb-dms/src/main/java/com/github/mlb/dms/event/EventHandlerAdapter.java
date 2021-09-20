package com.github.mlb.dms.event;

import com.github.mlb.dms.event.handler.DeleteEventHandler;
import com.github.mlb.dms.event.handler.UpdateEventHandler;
import com.github.mlb.dms.event.handler.WriteEventHandler;
import com.github.mlb.dms.event.model.BinlogDTO;
import com.github.mlb.dms.event.model.RowsData;
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

    private final List<EventHandler> eventHandlerList;
    private final Map<Long, TableMapEventData> tableEventDataMapCache = new HashMap<>(16);

    public EventHandlerAdapter() {
        eventHandlerList = new ArrayList<>();
        eventHandlerList.add(new WriteEventHandler());
        eventHandlerList.add(new UpdateEventHandler());
        eventHandlerList.add(new DeleteEventHandler());
    }

    @Nullable
    public BinlogDTO handler(EventData eventData) {
        if (eventData == null) {
            return null;
        }

        if (eventData instanceof TableMapEventData) {
            TableMapEventData mapEventData = (TableMapEventData) eventData;
            tableEventDataMapCache.put(mapEventData.getTableId(), mapEventData);
        }

        EventHandler handler = getHandler(eventData);
        if (handler == null) {
            LOGGER.info("can not find {} match handler", eventData.getClass());
            return null;
        }

        RowsData rowsData = handler.handler(eventData);
        TableMapEventData tableMapEventData = tableEventDataMapCache.get(rowsData.getTableId());

        BinlogDTO binlogDTO = new BinlogDTO();
        binlogDTO.setTableId(tableMapEventData.getTableId());
        binlogDTO.setDatabase(tableMapEventData.getDatabase());
        binlogDTO.setTable(tableMapEventData.getTable());
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