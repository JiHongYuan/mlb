package com.github.mlb.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2021/11/4 14:57
 */
@Data
public class BaseEntity implements Serializable {

    /** 创建者 */
    @JsonIgnore
    private transient Long createBy;

    /** 创建时间 */
    private Date createAt;

    /** 更新者 */
    @JsonIgnore
    private transient Long updateBy;

    /** 更新时间 */
    private Date updateAt;

    /** 是否删除 */
    @JsonIgnore
    private transient Boolean isDeleted;

}
