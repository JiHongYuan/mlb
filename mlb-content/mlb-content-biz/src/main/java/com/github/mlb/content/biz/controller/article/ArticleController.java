package com.github.mlb.content.biz.controller.article;

import com.github.mlb.common.utils.Result;
import com.github.mlb.content.api.article.entity.ArticleEntity;
import com.github.mlb.content.api.article.param.AddArticleParam;
import com.github.mlb.content.biz.article.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author JiHongYuan
 * @date 2021/9/15 22:24
 */
@AllArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleEntity> list() {
        return null;
    }

    @GetMapping("/{articleId}")
    public ArticleEntity get(@PathVariable String articleId) {
        return null;
    }

    @PostMapping
    public Result<ArticleEntity> add(@RequestBody AddArticleParam addArticleParam) {
        return Result.ofSuccess(articleService.add(addArticleParam));
    }

}
