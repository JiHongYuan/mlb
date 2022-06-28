package org.github.mlb.search.biz.listener;

import org.github.mlb.search.biz.listener.model.Row;
import org.elasticsearch.action.bulk.BulkRequest;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/21 14:26
 */
public interface EventActionHandler {

    /**
     * handler is support event
     *
     * @param eventAction action
     * @return support action
     */
    boolean support(String eventAction);

    BulkRequest handler(String index, List<Row> rows);

}
