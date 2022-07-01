package org.github.mlb.common.utils;

import org.github.mlb.common.model.UserInfo;

/**
 * @author jihongyuan
 * @date 2022/6/28 15:19
 */
public final class UserHolder {

    private static final ThreadLocal<UserInfo> USER_INFO_THREAD_LOCAL = new ThreadLocal<>();

    private UserHolder() {
    }

    public static UserInfo get() {
        return USER_INFO_THREAD_LOCAL.get();
    }

    public static Long getId() {
        return UserHolder.get().getId();
    }

    public static void set(UserInfo userInfo) {
        USER_INFO_THREAD_LOCAL.set(userInfo);
    }

    public static void remove() {
        USER_INFO_THREAD_LOCAL.remove();
    }

}
