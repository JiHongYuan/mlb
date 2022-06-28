package org.github.mlb.content.biz.repository.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.mlb.content.api.repository.entity.RepositoryEntity;
import org.github.mlb.content.api.repository.param.AddOrModifyRepositoryParam;
import org.github.mlb.content.api.repository.param.QueryRepositoryParam;

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
    Page<RepositoryEntity> pageByParam(IPage<?> page, QueryRepositoryParam param);

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
