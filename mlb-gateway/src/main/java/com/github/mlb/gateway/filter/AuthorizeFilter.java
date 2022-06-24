package com.github.mlb.gateway.filter;

import com.github.mlb.common.model.UserInfo;
import com.github.mlb.common.utils.JwtUtil;
import com.github.mlb.gateway.component.JwtProvider;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/24 16:46
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    private final JwtProvider jwtProvider;
    private final RedisTemplate<String, String> redisTemplate;

    public AuthorizeFilter(JwtProvider jwtProvider, RedisTemplate<String, String> redisTemplate) {
        this.jwtProvider = jwtProvider;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final HttpHeaders headers = exchange.getRequest().getHeaders();
        final List<String> authorizations = headers.get(JwtUtil.AUTHORIZATION);

        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    RequestPath path = exchange.getRequest().getPath();

                    if (authorizations == null) {
                        // TODO 重定向登陆界面
                        throw new RuntimeException("重定向登陆界面");
                    }

                    String token = authorizations.get(0);
                    String realToken = token.replace(JwtUtil.TOKEN_PREFIX, "");
                    // 验证 token 合法
                    UserInfo userInfo = jwtProvider.validateToken(realToken);
                    // 验证 redis token
                    token = redisTemplate.opsForValue().get("authorize:" + userInfo.getId());
                    jwtProvider.validateToken(token);

                    System.out.println("登陆成功！");
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }

}