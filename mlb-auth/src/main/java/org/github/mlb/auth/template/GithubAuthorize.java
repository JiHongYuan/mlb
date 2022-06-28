package org.github.mlb.auth.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.github.mlb.auth.model.GitHubUserInfo;
import org.github.mlb.auth.properties.GithubOAuth2Properties;
import org.github.mlb.auth.user.convert.UserConvert;
import org.github.mlb.common.model.UserInfo;
import org.github.mlb.common.utils.JSON;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author JiHongYuan
 * @date 2022/3/7 10:05
 */
@Component
public class GithubAuthorize extends AuthorizeTemplate {

    private final GithubOAuth2Properties oAuth2Properties;
    private final RestTemplate restTemplate;

    public GithubAuthorize(GithubOAuth2Properties oAuth2Properties, RestTemplate restTemplate) {
        this.oAuth2Properties = oAuth2Properties;
        this.restTemplate = restTemplate;
    }

    @Override
    public String callback(String code) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("client_id", oAuth2Properties.getClientId());
        requestBody.add("client_secret", oAuth2Properties.getClientSecret());
        requestBody.add("code", code);

        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(requestBody, httpHeaders);

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(oAuth2Properties.getAccessTokenUrl(), httpEntity, String.class);
        return JSON.parseObject(responseEntity.getBody(), Token.class).getAccessToken();
    }

    @Override
    public UserInfo request(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, "token " + accessToken);
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<GitHubUserInfo> responseEntity = this.restTemplate.exchange(
                oAuth2Properties.getUserInfoUrl(),
                HttpMethod.GET,
                new HttpEntity<Void>(null, httpHeaders),
                GitHubUserInfo.class);
        return UserConvert.INSTANCE.toUserInfo(responseEntity.getBody());
    }

    @Override
    public String getCode(HttpServletRequest request) {
        return request.getParameter("code");
    }

    @Override
    public String getRedirectUrl() {
        return oAuth2Properties.getAuthorizeUrl() +
                "?client_id=" + oAuth2Properties.getClientId() +
                "&redirect_uri=" + oAuth2Properties.getRedirectUri();
    }

    @Getter
    @Setter
    public static class Token implements Serializable {

        @JsonProperty("access_token")
        private String accessToken;

        private String scope;
        @JsonProperty("token_type")

        private String tokenType;
    }

}
