package com.github.mlb.dms.event;

import com.github.mlb.dms.event.model.RowsData;
import com.github.shyiko.mysql.binlog.event.EventData;

/**
 * @author JiHongYuan
 * @date 2021/9/20 0:58
 */

public interface EventHandler {
    /**
     * handler is support event
     *
     * @param event event
     * @return support event
     */
    boolean support(EventData event);

    /**
     * handler
     *
     * @param event event
     * @return rows
     */
    RowsData handler(EventData event);
}
