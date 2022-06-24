package com.github.mlb.content.biz.controller.category;

import com.github.mlb.common.utils.AddOperate;
import com.github.mlb.common.utils.Result;
import com.github.mlb.content.api.category.param.AddOrModifyCategoryParam;
import com.github.mlb.content.biz.category.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiHongYuan
 * @date 2022/3/10 14:31
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Result<Object> add(@Validated(value = {AddOperate.class}) @RequestBody AddOrModifyCategoryParam param) {
        categoryService.add(param);
        return Result.ofSuccess(null);
    }

}
