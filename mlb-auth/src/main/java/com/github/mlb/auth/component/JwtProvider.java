package com.github.mlb.auth.component;

import com.github.mlb.auth.properties.JwtProperties;
import com.github.mlb.common.utils.JSON;
import com.github.mlb.common.utils.JwtUtil;
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

    public String generateToken(Object subject) {
        return JwtUtil.generateToken(properties.getIssuer(), properties.getSecret(),
                properties.getExpirationSecond(), JSON.toJSONString(subject));
    }

    public String generateToken() {
        return JwtUtil.generateToken(properties.getIssuer(), properties.getSecret(),
                properties.getExpirationSecond(), "");
    }
}
