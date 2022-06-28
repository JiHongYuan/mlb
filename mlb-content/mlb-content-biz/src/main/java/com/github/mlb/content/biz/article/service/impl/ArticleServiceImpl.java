package com.github.mlb.content.biz.article.service.impl;

import com.github.mlb.content.api.article.convert.ArticleConvert;
import com.github.mlb.content.api.article.entity.ArticleEntity;
import com.github.mlb.content.api.article.param.AddArticleParam;

import com.github.mlb.content.api.category.entity.CategoryEntity;
import com.github.mlb.content.biz.article.manager.ArticleManager;
import com.github.mlb.content.biz.article.service.ArticleService;
import com.github.mlb.content.biz.category.manger.CategoryManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


/**
 * @author JiHongYuan
 * @date 2021/9/15 21:46
 */
@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleManager articleManager;
    private final CategoryManager categoryManager;

    @Override
    public ArticleEntity add(AddArticleParam param) {
        CategoryEntity category = categoryManager.getById(param.getCategoryId());
        Assert.notNull(category, "数据异常！");

        ArticleEntity article = ArticleConvert.INSTANCE.toEntity(param);
        article.setCategoryId(category.getId());
        article.setRepositoryId(category.getRepositoryId());
        article.setNewVersion(0);
        articleManager.add(article);
        return article;
    }

    @Override
    public void update(AddArticleParam addArticleParam) {
        // TODO
    }

}
