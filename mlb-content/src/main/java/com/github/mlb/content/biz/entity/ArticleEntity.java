package com.github.mlb.content.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:39
 */
@TableName("b_content_article")
public class ArticleEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @TableField
    private Integer newVersion;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(Integer newVersion) {
        this.newVersion = newVersion;
    }
}
