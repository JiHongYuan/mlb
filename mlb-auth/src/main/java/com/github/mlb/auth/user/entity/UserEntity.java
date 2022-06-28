package com.github.mlb.auth.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2022/3/7 11:10
 */

@Getter
@Setter
@TableName("t_auth_user")
public class UserEntity {

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 账号（第三方唯一标识）
     */
    private String access;

    /**
     * 状态(TODO)
     * */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createAt;

}