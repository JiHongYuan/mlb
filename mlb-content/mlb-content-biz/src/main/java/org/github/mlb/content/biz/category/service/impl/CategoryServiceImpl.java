package org.github.mlb.content.biz.category.service.impl;

import org.github.mlb.content.api.category.convert.CategoryConvert;
import org.github.mlb.content.api.category.entity.CategoryEntity;
import org.github.mlb.content.api.category.param.AddOrModifyCategoryParam;
import org.github.mlb.content.biz.category.manger.CategoryManager;
import org.github.mlb.content.biz.category.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2022/3/9 15:00
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    public static final Long userId = 1L;

    private final CategoryManager categoryManager;

    public CategoryServiceImpl(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    @Override
    public List<CategoryEntity> listByRepositoryId(Long repositoryId) {
        return categoryManager.listByRepositoryId(repositoryId);
    }

    @Override
    public List<CategoryEntity> listByRepositorySlug(String repositorySlug) {
        return categoryManager.listByRepositorySlug(repositorySlug);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CategoryEntity add(AddOrModifyCategoryParam param) {
        CategoryEntity category = CategoryConvert.INSTANCE.toEntity(param);

        category.setUserId(userId);

        /* 当前设置前驱节点 */
        CategoryEntity lastCategory = categoryManager.selectLastParentId(category.getParentId());
        category.setPrevId(lastCategory == null ? 0L : lastCategory.getId());
        categoryManager.add(category);

        /* 修改后驱节点 */
        if (lastCategory != null) {
            lastCategory.setNextId(category.getId());
            categoryManager.updateById(lastCategory);
        }

        return category;
    }

    @Override
    public CategoryEntity updateById(AddOrModifyCategoryParam param) {
        CategoryEntity category = CategoryConvert.INSTANCE.toEntity(param);

        categoryManager.updateById(CategoryEntity.builder().id(category.getId()).title(category.getTitle()).build());
        return category;
    }

    @Override
    public void removeByCategoryId(Long categoryId) {
        // TODO delete
    }

}
