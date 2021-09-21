package com.github.mlb.search.biz.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author JiHongYuan
 * @date 2021/9/20 18:19
 */

@Getter
@Setter
@Configurable
@ConfigurationProperties(prefix = "message.rabbitmq")
public class MQProperties {

    private String binlogSyncExchange;

    private String binlogSyncQueue;

    private String binlogSyncRoutingKey;

}