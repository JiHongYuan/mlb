package com.github.mlb.search.biz.repository.service.impl;

import com.github.mlb.search.biz.repository.entity.RepositoryDocument;
import com.github.mlb.search.biz.repository.manager.RepositoryManager;
import com.github.mlb.search.biz.repository.service.RepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/21 21:38
 */

@Service
public class RepositoryServiceImpl implements RepositoryService {
    private final RepositoryManager repositoryManager;

    @Override
    public List<RepositoryDocument> listByRepositoryNameAndDesc(String repositoryName, String desc) {
        return repositoryManager.queryByRepositoryNameAndDesc(repositoryName, desc);
    }

    @Override
    public RepositoryDocument getById(Integer repositoryId) {
        return repositoryManager.queryById(repositoryId);
    }

    public RepositoryServiceImpl(RepositoryManager repositoryManager) {
        this.repositoryManager = repositoryManager;
    }

}
