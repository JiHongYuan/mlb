package com.github.mlb.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2021/11/4 14:57
 */
@Data
public class BaseEntity implements Serializable {
    private Long createBy;
    private Date createAt;
    private Long updateBy;
    private Date updateAt;
    private Boolean isDeleted;
}
