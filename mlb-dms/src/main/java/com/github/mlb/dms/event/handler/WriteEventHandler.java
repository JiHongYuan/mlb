package com.github.mlb.dms.event.handler;

import com.github.mlb.dms.event.EventHandler;
import com.github.mlb.dms.event.model.RowsData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

/**
 * @author JiHongYuan
 * @date 2021/9/20 0:55
 */
public class WriteEventHandler implements EventHandler {

    @Override
    public boolean support(EventData event) {
        return false;
    }

    @Override
    public RowsData handler(EventData event) {
        WriteRowsEventData data = (WriteRowsEventData) event;

        RowsData rowsData = new RowsData();
        rowsData.setTableId(data.getTableId());
        rowsData.setRows(data.getRows());

        return rowsData;
    }
}
