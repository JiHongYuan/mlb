package com.github.mlb.dms.listener.handler;

import com.github.mlb.dms.listener.EventHandler;
import com.github.mlb.dms.listener.model.RowsData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author JiHongYuan
 * @date 2021/9/20 0:55
 */
public class UpdateEventHandler implements EventHandler {
    @Override
    public boolean support(EventData event) {
        return event instanceof UpdateRowsEventData;
    }

    @Override
    public RowsData handler(EventData event) {
        UpdateRowsEventData data = (UpdateRowsEventData) event;

        RowsData rowsData = new RowsData();
        rowsData.setTableId(data.getTableId());
        List<Serializable[]> rows = new ArrayList<>();

        for (Map.Entry<Serializable[], Serializable[]> row : data.getRows()) {
            rows.add(row.getValue());
        }
        rowsData.setRows(rows);

        return rowsData;
    }

    @Override
    public String eventAction() {
        return "update";
    }
}
