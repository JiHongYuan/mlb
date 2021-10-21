package com.github.mlb.auth.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author JiHongYuan
 * @date 2021/9/22 16:05
 */

@Getter
@Setter
@Configurable
@ConfigurationProperties(prefix = "oauth.github")
public class OAuth2Properties {

    private String clientId;
    private String clientSecret;
    private String authorizeUrl;
    private String redirectUri;
    private String accessTokenUrl;
    private String userInfoUrl;


}