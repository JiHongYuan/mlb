package com.github.mlb.content.biz.controller.category;

import com.github.mlb.common.utils.AddOperate;
import com.github.mlb.common.utils.ModifyOperate;
import com.github.mlb.common.utils.Result;
import com.github.mlb.content.api.category.entity.CategoryEntity;
import com.github.mlb.content.api.category.param.AddOrModifyCategoryParam;
import com.github.mlb.content.biz.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2022/3/10 14:31
 */
@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/id/{repositoryId}")
    public Result<List<CategoryEntity>> list(@PathVariable("repositoryId") Long repositoryId) {
        return Result.ofSuccess(categoryService.listByRepositoryId(repositoryId));
    }

    @GetMapping("/slug/{repositorySlug}")
    public Result<List<CategoryEntity>> list(@PathVariable("repositorySlug") String repositorySlug) {
        return Result.ofSuccess(categoryService.listByRepositorySlug(repositorySlug));
    }

    @PostMapping
    public Result<CategoryEntity> add(@Validated(value = {AddOperate.class}) @RequestBody AddOrModifyCategoryParam param) {
        return Result.ofSuccess(categoryService.add(param));
    }

    @PutMapping
    public Result<CategoryEntity> update(@Validated(value = {ModifyOperate.class}) @RequestBody AddOrModifyCategoryParam param) {
        // TODO 只支持修改标题，后续修改顺序单独接口
        return Result.ofSuccess(categoryService.updateById(param));
    }

    @DeleteMapping("/{categoryId}")
    public Result<Long> delete(@PathVariable("categoryId") Long categoryId) {
        // TODO 删除回收站
        categoryService.removeByCategoryId(categoryId);
        return Result.ofSuccess(categoryId);
    }


}
