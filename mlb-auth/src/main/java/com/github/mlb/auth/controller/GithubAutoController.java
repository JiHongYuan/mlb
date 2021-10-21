package com.github.mlb.auth.controller;

import com.github.mlb.auth.model.AccessToken;
import com.github.mlb.auth.properties.OAuth2Properties;
import com.github.mlb.common.utils.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JiHongYuan
 * @date 2021/9/22 22:16
 */

@RestController
@RequestMapping("/github")
public class GithubAutoController {
    private final RedisTemplate<String, String> redisTemplate;
    private final OAuth2Properties oAuth2Properties;
    private final RestTemplate restTemplate;

    private String authorizeUrl;


    @GetMapping("/authorize")
    public void authorize(HttpServletResponse response) throws IOException {
        response.sendRedirect(authorizeUrl);
    }

    @GetMapping("/oauth/callback")
    public void callback(@RequestParam("code") String code) {
        //1. 获取账号token
        AccessToken accessToken = requestAccessToken(code);
        //2. 获取用户信息
        String str = requestUserInfo(accessToken.getAccessToken());
        System.out.println(str);
    }

    public GithubAutoController(RedisTemplate<String, String> redisTemplate, OAuth2Properties oAuth2Properties, RestTemplate restTemplate) {
        this.redisTemplate = redisTemplate;
        this.oAuth2Properties = oAuth2Properties;
        this.restTemplate = restTemplate;

        initAuthorizeUrl();
    }
    private AccessToken requestAccessToken(String code) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("client_id", oAuth2Properties.getClientId());
        requestBody.add("client_secret", oAuth2Properties.getClientSecret());
        requestBody.add("code", code);

        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(requestBody, httpHeaders);

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(oAuth2Properties.getAccessTokenUrl(), httpEntity, String.class);

        String str = responseEntity.getBody();

        return JSON.parseObject(str, AccessToken.class);
    }

    private String requestUserInfo(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, "token " + accessToken);
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<String> responseEntity = this.restTemplate.exchange(oAuth2Properties.getUserInfoUrl(), HttpMethod.GET, new HttpEntity<Void>(null, httpHeaders), String.class);
        return responseEntity.getBody();
    }

    private void initAuthorizeUrl() {
        authorizeUrl = oAuth2Properties.getAuthorizeUrl() +
                "?client_id=" + oAuth2Properties.getClientId() +
                "&redirect_uri=" + oAuth2Properties.getRedirectUri();
    }

}