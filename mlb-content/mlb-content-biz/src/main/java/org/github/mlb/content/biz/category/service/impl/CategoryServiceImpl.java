package org.github.mlb.content.biz.category.service.impl;

import lombok.AllArgsConstructor;
import org.github.mlb.common.utils.UserHolder;
import org.github.mlb.content.biz.category.mapper.CategoryMapper;
import org.github.mlb.content.category.convert.CategoryConvert;
import org.github.mlb.content.category.entity.CategoryEntity;
import org.github.mlb.content.category.param.AddOrModifyCategoryParam;
import org.github.mlb.content.biz.category.manger.CategoryManager;
import org.github.mlb.content.biz.category.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2022/3/9 15:00
 */
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryManager categoryManager;
    private final CategoryMapper categoryMapper;


    @Override
    public List<CategoryEntity> listByRepositoryId(Long repositoryId) {
        return categoryManager.listByRepositoryId(repositoryId);
    }

    @Override
    public List<CategoryEntity> listByRepositorySlug(String repositorySlug) {
        return categoryManager.listByRepositorySlug(repositorySlug);
    }

    @Override
    public List<Long> listIdByUserId(Long userId) {
        return categoryMapper.selectListIdByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CategoryEntity add(AddOrModifyCategoryParam param) {
        CategoryEntity category = CategoryConvert.INSTANCE.toEntity(param);

        category.setUserId(UserHolder.getId());

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
