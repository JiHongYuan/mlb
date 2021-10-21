package com.github.mlb.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author JiHongYuan
 * @date 2021/9/22 22:04
 */
@Getter
@Setter
public class AccessToken implements Serializable {

    @JsonProperty("access_token")
    private String accessToken;

    private String scope;

    @JsonProperty("token_type")
    private String tokenType;

}
