package com.github.mlb.dms.message;

import com.github.mlb.common.enums.QueueMessageEnum;
import com.github.mlb.common.model.QueueMessage;
import com.github.mlb.common.utils.JSON;
import com.github.mlb.dms.config.properties.MQProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author JiHongYuan
 * @date 2021/9/20 18:31
 */

@Component
public class MessageQueuePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final MQProperties mqProperties;

    public void publish(QueueMessage queueMessage) {
        Object object = queueMessage.getBody();
        this.publish(queueMessage.getType(), JSON.toJSONString(object));
    }

    private void publish(QueueMessageEnum type, String message) {
        switch (type) {
            case BINLOG_SYNC:
                this.publish(mqProperties.getBinlogSyncExchange(), mqProperties.getBinlogSyncRoutingKey(), message);
                break;
            default:
                break;
        }
}

    private void publish(String exchange, String routingKey, String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    public MessageQueuePublisher(RabbitTemplate rabbitTemplate, MQProperties mqProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.mqProperties = mqProperties;
    }

}
