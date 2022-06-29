package org.github.mlb.content.biz.category.manger;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.mlb.common.utils.UserInfoHolder;
import org.github.mlb.content.api.category.entity.CategoryEntity;
import org.github.mlb.content.biz.category.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 10:27
 */
@Component
@AllArgsConstructor
public class CategoryManager extends ServiceImpl<CategoryMapper, CategoryEntity> {

    private final CategoryMapper categoryMapper;

    public CategoryEntity getById(Long categoryId) {
        return super.getOne(Wrappers.<CategoryEntity>lambdaQuery()
                .eq(CategoryEntity::getId, categoryId)
                .eq(CategoryEntity::getIsDeleted, false)
        );
    }

    public List<CategoryEntity> listByRepositoryId(Long repositoryId) {
        return this.listByIdOrSlug(repositoryId, null);
    }

    public List<CategoryEntity> listByRepositorySlug(String repositorySlug) {
        return this.listByIdOrSlug(null, repositorySlug);
    }

    private List<CategoryEntity> listByIdOrSlug(Long repositoryId, String repositorySlug) {
        return categoryMapper.selectListByIdOrSlug(repositoryId, repositorySlug);
    }

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
     * 查询最后一个分类nextId为null by parentId
     *
     * @param categoryId 分类ID
     * @return children list
     */
    public CategoryEntity selectLastParentId(Long categoryId) {
        return super.getOne(Wrappers.<CategoryEntity>lambdaQuery()
                .eq(CategoryEntity::getParentId, categoryId)
                .orderByAsc(CategoryEntity::getNextId)
                .last(" limit 1")
        );
    }

    public CategoryEntity add(CategoryEntity category) {
        Long userId = UserInfoHolder.getId();

        category.setCreateAt(new Date());
        category.setCreateBy(userId);
        category.setUpdateAt(new Date());
        category.setUpdateBy(userId);
        category.setIsDeleted(false);
        super.save(category);
        return category;
    }


}
