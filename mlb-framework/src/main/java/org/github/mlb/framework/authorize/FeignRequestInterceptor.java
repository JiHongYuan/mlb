package org.github.mlb.framework.authorize;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.github.mlb.common.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Open Feign 设置Token
 *
 * @author jihongyuan
 * @date 2022/6/30 16:01
 */
@Slf4j
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info("Feign 调用, url: {} ", template.request().url());

        HttpServletRequest request = Optional.ofNullable(RequestContextHolder.getRequestAttributes()).map(it -> ((ServletRequestAttributes) it).getRequest()).orElse(null);
        if (request == null) {
            return;
        }

        String authorization = request.getHeader(JwtUtil.AUTHORIZATION);
        template.header(JwtUtil.AUTHORIZATION, authorization);
    }

}
