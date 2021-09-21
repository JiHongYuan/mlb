package com.github.mlb.content.api.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:39
 */
@Getter
@Setter
@TableName("b_content_article")
public class ArticleEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private Integer userId;

    private Integer repositoryId;

    private Integer categoryId;

    private Integer newVersion;

    private Date updateTime;

}