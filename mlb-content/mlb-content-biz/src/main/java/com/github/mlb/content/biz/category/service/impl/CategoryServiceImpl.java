package com.github.mlb.content.biz.category.service.impl;

import com.github.mlb.common.utils.IdUtil;
import com.github.mlb.content.api.category.convert.CategoryConvert;
import com.github.mlb.content.api.category.entity.CategoryEntity;
import com.github.mlb.content.api.category.param.AddOrModifyCategoryParam;
import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import com.github.mlb.content.biz.category.manger.CategoryManager;
import com.github.mlb.content.biz.category.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author JiHongYuan
 * @date 2022/3/9 15:00
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryManager categoryManager;

    public CategoryServiceImpl(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }


    @Override
    public RepositoryEntity getById(Long categoryId) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AddOrModifyCategoryParam param) {
        CategoryEntity category = CategoryConvert.INSTANCE.toEntity(param);

        // TODO 获取登陆用户ID
        category.setUserId(1L);

        CategoryEntity lastCategory = categoryManager.selectLastParentId(category.getParentId());

        String slug = IdUtil.generateSlug();
        category.setSlug(slug);
        /* 当前设置前驱节点 */
        category.setPrevId(lastCategory.getId());
        categoryManager.save(category);

        /* 修改后驱节点 */
        lastCategory.setNextId(category.getId());
        categoryManager.updateById(lastCategory);
    }

    @Override
    public void updateById(AddOrModifyCategoryParam param) {
        CategoryEntity category = CategoryConvert.INSTANCE.toEntity(param);

        // 验证slug唯一
        String slug = category.getSlug();
        Assert.isTrue(categoryManager.uniqueSlugByUserIdAndRepositoryId(1L, category.getRepositoryId(), slug), "路径名称不能重复!");

        categoryManager.updateById(category);
    }
}
