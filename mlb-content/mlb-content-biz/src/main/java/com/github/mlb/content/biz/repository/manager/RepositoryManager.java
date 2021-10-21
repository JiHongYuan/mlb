package com.github.mlb.content.biz.repository.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mlb.common.utils.HttpUtil;
import com.github.mlb.content.biz.api.RepositoryServiceApi;
import com.github.mlb.content.biz.repository.mapper.RepositoryMapper;
import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:40
 */
@Component
public class RepositoryManager extends ServiceImpl<RepositoryMapper, RepositoryEntity> {
    private final RepositoryMapper repositoryMapper;
    private final RepositoryServiceApi repositoryServiceApi;

    public RepositoryEntity queryRepositoryById(Integer repositoryId) {

        return Optional
                .ofNullable(HttpUtil.apply(
                        RepositoryEntity.builder().id(repositoryId).build(),
                        rs -> repositoryServiceApi.queryRepositoryById(rs.getId())))

                .orElseGet(() -> repositoryMapper.selectById(repositoryId));

    }

    public RepositoryManager(RepositoryMapper repositoryMapper, RepositoryServiceApi repositoryServiceApi) {
        this.repositoryMapper = repositoryMapper;
        this.repositoryServiceApi = repositoryServiceApi;
    }

}
