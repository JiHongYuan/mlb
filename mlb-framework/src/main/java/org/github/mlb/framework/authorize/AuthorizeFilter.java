package org.github.mlb.framework.authorize;

import org.apache.catalina.connector.RequestFacade;
import org.github.mlb.common.model.UserInfo;
import org.github.mlb.common.utils.JwtUtil;
import org.github.mlb.common.utils.UserHolder;
import org.redisson.api.RedissonClient;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 认证拦截器
 *
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
        if (!StringUtils.hasLength(authorization) || !authorization.startsWith(JwtUtil.TOKEN_PREFIX)) {
            // TODO 认证登录
            return;
        }

        String token = authorization.substring(JwtUtil.TOKEN_PREFIX.length());
        UserInfo userInfo = redissonClient.<UserInfo>getBucket("auth:userInfo:" + token).get();
        // "/servlet-context-path/api 可能没有token
        if (userInfo != null || new AntPathMatcher().match("/*/api/**", ((RequestFacade) request).getRequestURI())) {
            try {
                UserHolder.set(userInfo);
                filterChain.doFilter(request, response);
            } finally {
                redissonClient.<UserInfo>getBucket("auth:userInfo:" + token).setAndKeepTTL(userInfo);
                UserHolder.remove();
            }
        }
    }
}
