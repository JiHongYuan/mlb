package com.github.mlb.content.biz.category.manger;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mlb.content.api.category.entity.CategoryEntity;
import com.github.mlb.content.biz.category.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 10:27
 */
@Component
public class CategoryManager extends ServiceImpl<CategoryMapper, CategoryEntity> {

    /**
     * 查询分类列表 by parentId
     *
     * @param categoryId 分类ID
     * @return children list
     */
    public List<CategoryEntity> selectListByParentId(Long categoryId) {
        return super.list(Wrappers.<CategoryEntity>lambdaQuery()
                .eq(CategoryEntity::getParentId, categoryId)
                .orderByAsc(CategoryEntity::getNextId)
        );
    }

    /**
     * 查询最后一个分类 by parentId
     *
     * @param categoryId 分类ID
     * @return children list
     */
    public CategoryEntity selectLastParentId(Long categoryId) {
        return super.getOne(Wrappers.<CategoryEntity>lambdaQuery()
                .eq(CategoryEntity::getParentId, categoryId)
                .orderByDesc(CategoryEntity::getNextId)
                .last(" limit 1")
        );
    }

    /**
     * 验证 {@code slug} 唯一
     *
     * @param slug   路径名称
     * @param userId 用户ID
     * @return unique true
     */
    public boolean uniqueSlugByUserIdAndRepositoryId(Long userId, Long repositoryId, String slug) {
        return super.count(Wrappers.<CategoryEntity>lambdaQuery()
                .eq(CategoryEntity::getSlug, slug)
                .eq(CategoryEntity::getRepositoryId, repositoryId)
                .eq(CategoryEntity::getUserId, userId)) == 1;
    }
}
