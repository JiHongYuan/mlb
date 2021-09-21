package com.github.mlb.dms.listener;

import com.github.mlb.dms.listener.model.RowsData;
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

    /**
     * 获取实践
     *
     * @return insert/update/delete
     */
    String eventAction();

}
