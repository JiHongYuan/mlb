package com.github.mlb.content.biz.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mlb.content.api.article.entity.ArticleEntity;
import com.github.mlb.content.api.article.entity.ArticleVersionEntity;
import com.github.mlb.content.api.article.request.ArticleRequest;

import com.github.mlb.content.biz.article.mapper.ArticleMapper;
import com.github.mlb.content.biz.article.service.ArticleService;
import com.github.mlb.content.biz.article.service.ArticleVersionService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2021/9/15 21:46
 */
@Service
public class ArticleServiceImpl extends
        ServiceImpl<ArticleMapper, ArticleEntity> implements ArticleService {

    private final ArticleVersionService articleVersionService;

    @Override
    public void add(ArticleRequest articleRequest) {
        int version = 1;

        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setNewVersion(version);

        ArticleVersionEntity articleVersionEntity = new ArticleVersionEntity();
        articleVersionEntity.setVersion(version);
        articleVersionEntity.setContent(articleRequest.getContent());
        articleVersionService.save(articleVersionEntity);

        save(articleEntity);
    }

    @Override
    public void update(ArticleRequest articleRequest) {
        ArticleEntity lastArticle = getById(articleRequest.getArticleId());

        Date updateTime = lastArticle.getUpdateTime();

        ArticleVersionEntity articleVersion = new ArticleVersionEntity();
        articleVersion.setArticleId(lastArticle.getId());
        articleVersion.setContent(articleRequest.getContent());
        articleVersion.setVersion(lastArticle.getNewVersion());
        boolean isAdd = articleVersionService.addOrUpdateByNewVersionOnUpdateTime(articleVersion, updateTime);
        if (isAdd) {
            lastArticle.setNewVersion(lastArticle.getNewVersion() + 1);
            super.updateById(lastArticle);
        }
    }

    public ArticleServiceImpl(ArticleVersionService articleVersionService) {
        this.articleVersionService = articleVersionService;
    }


    public static void main(String[] args) throws InterruptedException {
        Date d1 = new Date();
        Thread.sleep(3000);
        Date d2 = new Date();

        System.out.println(d2.getTime() - d1.getTime());
    }
}
