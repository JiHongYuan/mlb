package com.github.mlb.search.biz.listener;

import com.github.mlb.common.model.BinlogDTO;
import com.github.mlb.common.utils.JSON;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author JiHongYuan
 * @date 2021/9/20 22:28
 */

@Component
@RabbitListener(queues = "binlog-sync-queue")
public class BinlogSyncListener {

    private final EventActionAdapter eventActionAdapter;

    public BinlogSyncListener(RestHighLevelClient restHighLevelClient) {
        this.eventActionAdapter = new EventActionAdapter(restHighLevelClient);
    }

    @RabbitHandler
    public void process(String message) {
        BinlogDTO binlogDTO = JSON.parseObject(message, BinlogDTO.class);
        eventActionAdapter.handler(binlogDTO);
    }

}