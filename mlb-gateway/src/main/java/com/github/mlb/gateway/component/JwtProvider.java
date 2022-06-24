package com.github.mlb.gateway.component;

import com.github.mlb.common.model.UserInfo;
import com.github.mlb.common.utils.JwtUtil;
import com.github.mlb.gateway.properties.JwtProperties;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * @author JiHongYuan
 * @date 2022/3/8 11:19
 */
@Component
public class JwtProvider {

    @Getter
    public final JwtProperties properties;

    public JwtProvider(JwtProperties properties) {
        this.properties = properties;
    }

    public UserInfo validateToken(String token) {
        return JwtUtil.validateToken(token, properties.getIssuer(), properties.getSecret());
    }

}