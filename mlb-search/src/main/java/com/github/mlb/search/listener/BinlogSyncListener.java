package com.github.mlb.search.listener;

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

    @RabbitHandler
    public void process(String message) {
        System.out.println(message);
    }

}