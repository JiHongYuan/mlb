package com.github.mlb.content.biz.repository.service.impl;

import com.github.mlb.common.utils.IdUtil;
import com.github.mlb.content.api.repository.convert.RepositoryConvert;
import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import com.github.mlb.content.api.repository.param.QueryRepositoryParam;
import com.github.mlb.content.biz.repository.manager.RepositoryManager;
import com.github.mlb.content.api.repository.param.AddOrModifyRepositoryParam;
import com.github.mlb.content.biz.repository.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:43
 */
@Service
@AllArgsConstructor
public class RepositoryServiceImpl implements RepositoryService {

    public static final Long userId = 1L;

    private final RepositoryManager repositoryManager;

    @Override
    public RepositoryEntity getByRepositoryId(Long repositoryId) {
        Assert.isTrue(repositoryId > 0, "参数异常");
        return repositoryManager.selectRepositoryById(repositoryId);
    }

    @Override
    public List<RepositoryEntity> listByParam(QueryRepositoryParam param) {
        return null;
    }

    @Override
    public RepositoryEntity add(AddOrModifyRepositoryParam addRepositoryParam) {
        RepositoryEntity repository = RepositoryConvert.INSTANCE.toEntity(addRepositoryParam);

        repository.setUserId(userId);

        String slug = IdUtil.generateSlug();
        repository.setSlug(slug);

        // insert
        return repositoryManager.add(repository);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RepositoryEntity updateById(AddOrModifyRepositoryParam modifyRepositoryParam) {
        RepositoryEntity repository = RepositoryConvert.INSTANCE.toEntity(modifyRepositoryParam);

        // 验证slug唯一
        String slug = repository.getSlug();
        Assert.isTrue(!repositoryManager.existSlugByUserId(userId, repository.getId(), slug), "路径名称不能重复!");

        repositoryManager.updateById(repository);
        return repository;
    }

    @Override
    public void removeByRepositoryId(Long repositoryId) {
        RepositoryEntity repository = Optional
                .ofNullable(repositoryManager.selectRepositoryById(repositoryId))
                .orElseThrow(() -> new RuntimeException("非法操作, 数据不存在"));

        repositoryManager.deleteRepositoryById(repository.getId());
    }

}