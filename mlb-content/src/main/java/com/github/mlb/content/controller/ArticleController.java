package com.github.mlb.content.controller;

import com.github.mlb.content.biz.entity.ArticleEntity;
import com.github.mlb.content.biz.request.ArticleRequest;
import com.github.mlb.content.biz.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/15 22:24
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleEntity> get() {
        return articleService.list();
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
