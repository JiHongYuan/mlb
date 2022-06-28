package org.github.mlb.dms.message;

import org.github.mlb.common.enums.QueueMessageEnum;
import org.github.mlb.common.model.QueueMessage;
import org.github.mlb.common.utils.JSON;
import org.github.mlb.dms.config.properties.MQProperties;
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
            // binlog同步
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
