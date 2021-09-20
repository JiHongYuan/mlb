package com.github.mlb.dms.config;

import com.github.mlb.dms.properties.MQProperties;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiHongYuan
 * @date 2021/9/20 18:23
 */
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    private final MQProperties mqProperties;

    @Bean
    public Queue binlogSyncQueue() {
        return QueueBuilder
                .durable(mqProperties.getBinlogSyncQueue())
                .build();
    }

    @Bean
    public TopicExchange binlogSyncExchange() {
        return ExchangeBuilder
                .topicExchange(mqProperties.getBinlogSyncExchange())
                .durable(true)
                .build();
    }

    @Bean
    public Binding binlogSyncBinding() {
        return BindingBuilder
                .bind(binlogSyncQueue())
                .to(binlogSyncExchange())
                .with(mqProperties.getBinlogSyncRoutingKey());
    }

    public RabbitMQConfig(MQProperties mqProperties) {
        this.mqProperties = mqProperties;
    }

}