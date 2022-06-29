package org.github.mlb.framework.filter;

import org.github.mlb.common.model.UserInfo;
import org.github.mlb.common.utils.JwtUtil;
import org.github.mlb.common.utils.UserInfoHolder;
import org.redisson.api.RedissonClient;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author jihongyuan
 * @date 2022/6/29 9:26
 */
public class AuthorizeFilter implements Filter {

    private final RedissonClient redissonClient;

    public AuthorizeFilter(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String authorization = req.getHeader(JwtUtil.AUTHORIZATION);
        if(!StringUtils.hasLength(authorization) && authorization.startsWith(JwtUtil.TOKEN_PREFIX)){
            // TODO 认证登录
            return;
        }

        UserInfo userInfo = redissonClient.<UserInfo>getBucket("auth:userInfo:" + authorization.substring(JwtUtil.TOKEN_PREFIX.length())).get();
        if(userInfo == null){
            // TODO 认证登录
            return;
        }
        try {
            UserInfoHolder.set(userInfo);
            filterChain.doFilter(request, response);
        } finally {
            UserInfoHolder.remove();
        }

    }
}
