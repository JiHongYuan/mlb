package org.github.mlb.auth.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author JiHongYuan
 * @date 2021/9/22 16:05
 */
@Data
@Configurable
@ConfigurationProperties(prefix = "oauth.github")
public class GithubOAuth2Properties {

    private String clientId;

    private String clientSecret;

    private String authorizeUrl;

    private String redirectUri;

    private String accessTokenUrl;

    private String userInfoUrl;

}