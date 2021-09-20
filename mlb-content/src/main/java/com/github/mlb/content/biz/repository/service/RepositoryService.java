package com.github.mlb.content.biz.repository.service;

import com.github.mlb.content.biz.repository.params.AddOrModifyRepositoryParam;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:43
 */
public interface RepositoryService {

    /**
     * add repository
     *
     * @param addRepositoryParam addParam
     */
    boolean addRepository(AddOrModifyRepositoryParam addRepositoryParam);

    /**
     * modify repository
     *
     * @param modifyRepositoryParam modifyParam
     */
    boolean modifyRepository(AddOrModifyRepositoryParam modifyRepositoryParam);

    void removeRepository();
}
