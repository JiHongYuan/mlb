package com.github.mlb.auth.template;

import com.github.mlb.common.model.UserInfo;

/**
 * @author JiHongYuan
 * @date 2022/3/7 9:55
 */
public interface IAuthorizeProcessor {

    /**
     * 处理回调
     *
     * @param code 用户的凭证
     * @return accessToken
     */
    String callback(String code);

    /**
     * 处理请求
     *
     * @param accessToken accessToken
     * @return 用户信息
     */
    UserInfo request(String accessToken);

}