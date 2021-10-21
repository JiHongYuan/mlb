package com.github.mlb.content.biz.repository.service.impl;

import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import com.github.mlb.content.biz.repository.manager.RepositoryManager;
import com.github.mlb.content.api.repository.params.AddOrModifyRepositoryParam;
import com.github.mlb.content.biz.repository.service.RepositoryService;
import com.github.mlb.common.utils.Dozer;
import org.springframework.stereotype.Service;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:43
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private final RepositoryManager repositoryManager;

    @Override
    public RepositoryEntity queryRepositoryById(Integer repositoryId) {
        return repositoryManager.queryRepositoryById(repositoryId);
    }

    @Override
    public void addRepository(AddOrModifyRepositoryParam addRepositoryParam) {
        RepositoryEntity repository = convertToRepository(addRepositoryParam);
        repositoryManager.save(repository);
    }

    @Override
    public void modifyRepository(AddOrModifyRepositoryParam modifyRepositoryParam) {
        RepositoryEntity repository = convertToRepository(modifyRepositoryParam);
        repositoryManager.updateById(repository);
    }

    @Override
    public void removeRepository() {

    }

    private RepositoryEntity convertToRepository(AddOrModifyRepositoryParam param) {
        return Dozer.convert(param, RepositoryEntity.class);
    }

    public RepositoryServiceImpl(RepositoryManager repositoryManager) {
        this.repositoryManager = repositoryManager;
    }

}