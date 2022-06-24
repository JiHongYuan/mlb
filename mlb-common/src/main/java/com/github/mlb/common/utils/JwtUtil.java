package com.github.mlb.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.mlb.common.model.JwtInfo;
import com.github.mlb.common.model.UserInfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author JiHongYuan
 * @date 2022/3/7 14:26
 */
public class JwtUtil {

    /**
     * 前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 表头授权
     */
    public static final String AUTHORIZATION = "Authorization";

    public static String generateToken(String issuer, String secret, Integer expiresSecond, String subject) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.SECOND, expiresSecond);

        return TOKEN_PREFIX + JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withSubject(subject)
                .withExpiresAt(calendar.getTime())
                .sign(builderAlgorithm(secret));
    }

    public static UserInfo validateToken(String token, String issuer, String secret) {
        JWTVerifier verifier = JWT.require(builderAlgorithm(secret))
                .withIssuer(issuer)
                .build();

        DecodedJWT jwt = verifier.verify(token);
        String payload = jwt.getPayload();
        return JSON.parseObject(payload, UserInfo.class);
    }

    private static Algorithm builderAlgorithm(String security) {
        return Algorithm.HMAC256(security);
    }

}