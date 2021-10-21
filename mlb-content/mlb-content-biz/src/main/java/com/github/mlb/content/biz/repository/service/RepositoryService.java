package com.github.mlb.content.biz.repository.service;

import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import com.github.mlb.content.api.repository.params.AddOrModifyRepositoryParam;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:43
 */
public interface RepositoryService {

    RepositoryEntity queryRepositoryById(Integer repositoryId);

    /**
     * add repository
     *
     * @param addRepositoryParam addParam
     */
    void addRepository(AddOrModifyRepositoryParam addRepositoryParam);

    /**
     * modify repository
     *
     * @param modifyRepositoryParam modifyParam
     */
    void modifyRepository(AddOrModifyRepositoryParam modifyRepositoryParam);

    void removeRepository();
}
