package org.github.mlb.auth.template;

import org.github.mlb.common.model.UserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证模板
 *
 * @author JiHongYuan
 * @date 2022/3/7 9:59
 */
public abstract class AuthorizeTemplate implements IAuthorizeProcessor {

    public UserInfo authorize(HttpServletRequest request) {
        String code = getCode(request);
        String callback = callback(code);
        return request(callback);
    }

    /**
     * 回调
     *
     * @param code 回调Code
     * @return accessToken
     */
    @Override
    public abstract String callback(String code);

    /**
     * 请求用户信息
     *
     * @param accessToken token
     * @return userInfo
     */
    @Override
    public abstract UserInfo request(String accessToken);

    /**
     * 获取code
     *
     * @param request httpRequest
     * @return code
     */
    public abstract String getCode(HttpServletRequest request);

    /**
     * 字获取重定向地址
     *
     * @return redirect url
     */
    public abstract String getRedirectUrl();

}