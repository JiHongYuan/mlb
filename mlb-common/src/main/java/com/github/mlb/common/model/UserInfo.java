package com.github.mlb.common.model;

import lombok.Data;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2022/1/21 11:13
 */
@Data
public class UserInfo {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 账号（第三方唯一标识）
     */
    private String access;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态(TODO)
     * */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createAt;

}