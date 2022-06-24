package com.github.mlb.content.biz.category.service;

import com.github.mlb.content.api.category.param.AddOrModifyCategoryParam;
import com.github.mlb.content.api.repository.entity.RepositoryEntity;

/**
 * @author JiHongYuan
 * @date 2022/3/9 15:00
 */
public interface CategoryService {

    /**
     * get category by {@code categoryId}
     *
     * @param categoryId 分类ID
     * @return RepositoryEntity
     */
    RepositoryEntity getById(Long categoryId);

    /**
     * add category
     *
     * @param param param
     */
    void add(AddOrModifyCategoryParam param);

    /**
     * modify category {@code param} categoryId
     *
     * @param param param
     */
    void updateById(AddOrModifyCategoryParam param);

}
