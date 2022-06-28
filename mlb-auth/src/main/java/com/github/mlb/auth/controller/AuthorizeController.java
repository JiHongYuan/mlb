package com.github.mlb.auth.controller;

import com.github.mlb.auth.component.JwtProvider;
import com.github.mlb.auth.template.GithubAuthorize;
import com.github.mlb.auth.user.entity.UserEntity;
import com.github.mlb.auth.user.service.UserService;
import com.github.mlb.common.model.UserInfo;
import com.github.mlb.common.utils.JSON;
import com.github.mlb.common.utils.Result;
import lombok.AllArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author JiHongYuan
 * @date 2021/9/22 22:16
 */
@AllArgsConstructor
@RestController
@RequestMapping
public class AuthorizeController {

    private RedissonClient redissonClient;

    private final UserService userService;
    private final GithubAuthorize githubAuthorize;
    private final JwtProvider jwtProvider;

    @GetMapping("/authorize")
    public void authorize(HttpServletResponse response) throws IOException {
        response.sendRedirect(githubAuthorize.getRedirectUrl());
    }

    @GetMapping("/oauth/callback")
    public Result<String> callback(HttpServletRequest request) {
        UserInfo userInfo = githubAuthorize.authorize(request);
        userInfo.setCurrentAt(new Date());
        UserEntity userEntity = Optional.ofNullable(userService.getByAccess(userInfo.getAccess()))
                // 新增用户
                .orElseGet(() -> {
                    UserEntity user = new UserEntity();
                    user.setAccess(userInfo.getAccess());
                    user.setCreateAt(new Date());
                    userService.save(user);
                    return user;
                });

        userInfo.setId(userEntity.getId());
        userInfo.setStatus(userEntity.getStatus());

        String token = jwtProvider.generateToken().substring(7);
        String msg = redissonClient.<String>getBucket("auth:" + userEntity.getId()).getAndSet(token, jwtProvider.getProperties().getExpirationSecond(), TimeUnit.SECONDS);
        if (msg != null) {
            redissonClient.getBucket("userInfo:" + msg).delete();
        }
        redissonClient.getBucket("userInfo:" + token).set(userInfo, jwtProvider.getProperties().getExpirationSecond(), TimeUnit.SECONDS);
        return Result.ofSuccess(token);
    }

}