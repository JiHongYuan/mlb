package com.github.mlb.auth.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jihongyuan
 * @date 2022/6/28 15:08
 */
@Data
@Configurable
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private int database = 0;

    private String host = "127.0.0.1";

    private int port = 6347;

    private String password;

    private int timeout = 3000;

}
