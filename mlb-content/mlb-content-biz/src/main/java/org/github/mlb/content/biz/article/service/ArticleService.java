package org.github.mlb.content.biz.article.service;

import org.github.mlb.content.api.article.entity.ArticleEntity;
import org.github.mlb.content.api.article.param.AddArticleParam;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:45
 */
public interface ArticleService {

    ArticleEntity add(AddArticleParam param);

    void update(AddArticleParam addArticleParam);

}
