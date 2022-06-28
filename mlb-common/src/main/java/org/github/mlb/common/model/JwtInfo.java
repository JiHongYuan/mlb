package org.github.mlb.common.model;

import lombok.Getter;

/**
 * @author JiHongYuan
 * @date 2022/3/7 15:27
 */
@Getter
public class JwtInfo {

    private final String issuer;

    private final String base64Security;

    private Integer expirationSecond;

    public JwtInfo(String issuer, String base64Security, Integer expirationSecond) {
        this.issuer = issuer;
        this.base64Security = base64Security;
        this.expirationSecond = expirationSecond;
    }

    public JwtInfo(String issuer, String base64Security) {
        this.issuer = issuer;
        this.base64Security = base64Security;
    }

}
