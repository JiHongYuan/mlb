package org.github.mlb.common.model;

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * TODO
 *
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
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date currentAt;

    /**
     * 仓库ID
     */
    private Set<Long> repositories;

    /**
     * 分类ID
     */
    private Set<Long> categories;

    /**
     * 文章ID
     */
    private Set<Long> articles;

}