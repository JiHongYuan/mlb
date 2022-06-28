package org.github.mlb.search.biz.listener.handler;

import org.github.mlb.search.biz.listener.EventActionHandler;
import org.github.mlb.search.biz.listener.model.Row;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/21 14:25
 */
public class InsertEventActionHandler implements EventActionHandler {

    @Override
    public boolean support(String eventAction) {
        return "insert".equals(eventAction);
    }

    @Override
    public BulkRequest handler(String index, List<Row> rows) {
        BulkRequest request = new BulkRequest();

        for (Row row : rows) {
            IndexRequest indexRequest = new IndexRequest(index);
            indexRequest
                    .id(String.valueOf(row.getId()))
                    .source(row.getData());
            request.add(indexRequest);
        }
        return request;
    }

}