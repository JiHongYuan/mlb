package org.github.mlb.search.biz.repository.service;

import org.github.mlb.search.biz.repository.entity.RepositoryDocument;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/21 21:37
 */
public interface RepositoryService {

    List<RepositoryDocument> listByRepositoryNameAndDesc(String repositoryName, String desc);

    RepositoryDocument getById(Integer repositoryId);

}