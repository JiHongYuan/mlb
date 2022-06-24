package com.github.mlb.content.biz.controller.article;

import com.github.mlb.content.api.article.entity.ArticleEntity;
import com.github.mlb.content.api.article.request.ArticleRequest;
import com.github.mlb.content.biz.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author JiHongYuan
 * @date 2021/9/15 22:24
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleEntity> get() {
//        String dateKey = DateFormatUtils.format(new Date(), "yyyyMMdd");
//        Long increment = redisTemplate.opsForValue().increment(dateKey, 1);
//        if (increment == 1) {
//
//            redisTemplate.expire(dateKey, 86400, TimeUnit.SECONDS);
//        }
//        String value = StringUtils.leftPad(String.valueOf(increment), 5, "0");
//        System.out.println(dateKey + value);
//        return null;
////        return articleService.list();
        return null;
    }

    @GetMapping("/{articleId}")
    public ArticleEntity getOne(String articleId) {
        return articleService.getById(articleId);
    }

    @PostMapping
    public void add(ArticleRequest articleRequest) {
        articleService.add(articleRequest);
    }

    @PatchMapping
    public void put(ArticleRequest articleRequest) {
        articleService.add(articleRequest);
    }

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

}
