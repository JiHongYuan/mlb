package com.github.mlb.content.biz.repository.service;

import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import com.github.mlb.content.api.repository.param.AddOrModifyRepositoryParam;
import com.github.mlb.content.api.repository.param.QueryRepositoryParam;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:43
 */
public interface RepositoryService {

    /**
     * get repository by {@code repositoryId}
     *
     * @param repositoryId 仓库ID
     * @return entity
     */
    RepositoryEntity getByRepositoryId(Long repositoryId);

    /**
     * 查询分页
     *
     * @param param 入参
     * @return list
     */
    List<RepositoryEntity> listByParam(QueryRepositoryParam param);

    /**
     * add repository
     *
     * @param param param
     * @return entity
     */
    RepositoryEntity add(AddOrModifyRepositoryParam param);

    /**
     * modify repository {@code param} by repositoryId
     *
     * @param param param
     * @return entity
     */
    RepositoryEntity updateById(AddOrModifyRepositoryParam param);

    /**
     * remove repository by {@code slug}
     *
     * @param repositoryId 仓库ID
     */
    void removeByRepositoryId(Long repositoryId);

}
