package org.github.mlb.content.biz.article.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.mlb.common.utils.UserInfoHolder;
import org.github.mlb.content.api.article.entity.ArticleEntity;
import org.github.mlb.content.biz.article.mapper.ArticleMapper;
import org.github.mlb.content.biz.article.service.ArticleVersionService;
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
        Long userId = UserInfoHolder.getId();

        article.setCreateAt(new Date());
        article.setCreateBy(userId);
        article.setUpdateAt(new Date());
        article.setUpdateBy(userId);
        article.setIsDeleted(false);
        super.save(article);
        return article;
    }

}
