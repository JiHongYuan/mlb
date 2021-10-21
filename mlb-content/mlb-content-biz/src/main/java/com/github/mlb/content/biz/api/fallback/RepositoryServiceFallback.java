package com.github.mlb.content.biz.api.fallback;

import com.github.mlb.common.utils.Result;
import com.github.mlb.content.biz.api.RepositoryServiceApi;
import com.github.mlb.content.api.repository.entity.RepositoryEntity;

/**
 * @author JiHongYuan
 * @date 2021/9/21 21:25
 */
public class RepositoryServiceFallback implements RepositoryServiceApi {


    @Override
    public Result<RepositoryEntity> queryRepositoryById(Integer repositoryId) {
        return null;
    }

}
