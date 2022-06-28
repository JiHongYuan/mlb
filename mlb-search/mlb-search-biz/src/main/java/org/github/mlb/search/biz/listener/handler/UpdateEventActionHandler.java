package org.github.mlb.search.biz.listener.handler;

import org.github.mlb.search.biz.listener.EventActionHandler;
import org.github.mlb.search.biz.listener.model.Row;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.update.UpdateRequest;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/21 14:25
 */
public class UpdateEventActionHandler implements EventActionHandler {

    @Override
    public boolean support(String eventAction) {
        return "update".equals(eventAction);
    }

    @Override
    public BulkRequest handler(String index, List<Row> rows) {
        BulkRequest request = new BulkRequest();

        for (Row row : rows) {
            UpdateRequest updateRequest = new UpdateRequest(index, String.valueOf(row.getId()));
            updateRequest.doc(row.getData());
            request.add(updateRequest);
        }
        return request;
    }

}