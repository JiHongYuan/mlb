package org.github.mlb.search.biz.listener.handler;

import org.github.mlb.search.biz.listener.EventActionHandler;
import org.github.mlb.search.biz.listener.model.Row;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/21 14:25
 */
public class DeleteEventActionHandler implements EventActionHandler {

    @Override
    public boolean support(String eventAction) {
        return "delete".equals(eventAction);
    }

    @Override
    public BulkRequest handler(String index, List<Row> rows) {
        BulkRequest request = new BulkRequest();

        for (Row row : rows) {
            DeleteRequest deleteRequest = new DeleteRequest(index, String.valueOf(row.getId()));
            request.add(deleteRequest);
        }
        return request;
    }

}
