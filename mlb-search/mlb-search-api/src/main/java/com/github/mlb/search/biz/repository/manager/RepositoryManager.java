package com.github.mlb.search.biz.repository.manager;

import com.github.mlb.search.biz.repository.entity.RepositoryDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 15:57
 */
@Repository
public interface RepositoryManager extends ElasticsearchRepository<RepositoryDocument, Long> {

    /**
     * find by
     *
     * @param repositoryName 仓库名称
     * @param desc           简介
     * @return collection
     */
    List<RepositoryDocument> findByRepositoryNameAndAndDesc(String repositoryName, String desc);

}