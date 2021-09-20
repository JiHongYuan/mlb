package com.github.mlb.content.biz.article.request;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:48
 */
public class ArticleRequest {

    private String articleId;

    private String content;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
