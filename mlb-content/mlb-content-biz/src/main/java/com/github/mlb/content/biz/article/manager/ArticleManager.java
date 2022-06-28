package com.github.mlb.content.biz.article.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mlb.content.api.article.entity.ArticleEntity;
import com.github.mlb.content.biz.article.mapper.ArticleMapper;
import com.github.mlb.content.biz.article.service.ArticleVersionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jihongyuan
 * @date 2022/6/27 17:02
 */
@Component
@AllArgsConstructor
public class ArticleManager extends ServiceImpl<ArticleMapper, ArticleEntity> {


    private final ArticleVersionService articleVersionService;

    public ArticleEntity add(ArticleEntity article) {
        article.setCreateAt(new Date());
        article.setCreateBy(1L);
        article.setUpdateAt(new Date());
        article.setUpdateBy(1L);
        article.setIsDeleted(false);
        super.save(article);
        return article;
    }

}
