package com.github.mlb.content.api.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:39
 */
@TableName("b_content_article_version")
public class ArticleVersionEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField
    private String articleId;

    @TableField
    private String content;

    @TableField
    private Integer version;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}