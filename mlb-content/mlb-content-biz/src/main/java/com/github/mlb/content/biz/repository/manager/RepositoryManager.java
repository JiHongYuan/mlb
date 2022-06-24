package com.github.mlb.content.biz.repository.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mlb.content.biz.api.RepositoryServiceApi;
import com.github.mlb.content.biz.repository.mapper.RepositoryMapper;
import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:40
 */
@Component
@AllArgsConstructor
public class RepositoryManager extends ServiceImpl<RepositoryMapper, RepositoryEntity> {
    private final RepositoryMapper repositoryMapper;
    private final RepositoryServiceApi repositoryServiceApi;

    /**
     * 查询 {@code repositoryId}
     *
     * @param repositoryId 仓库ID
     */
    public RepositoryEntity selectRepositoryById(Long repositoryId) {
        return repositoryMapper.selectById(repositoryId);
    }

    /**
     * 查询 {@code repositoryId}
     *
     * @param slug 路径名称
     */
    public RepositoryEntity selectRepositoryBySlug(String slug) {
        return repositoryMapper.selectBySlug(slug);
    }

    /**
     * 删除 {@code repositoryId}
     *
     * @param repositoryId 仓库ID
     */
    public void deleteRepositoryById(Long repositoryId) {
        repositoryMapper.deleteById(repositoryId);
    }

    /**
     * 验证 {@code slug} 唯一
     *
     * @param slug   路径名称
     * @param userId 用户ID
     * @return unique true
     */
    public boolean existSlugByUserId(Long userId, Long repositoryId, String slug) {
        return repositoryMapper.selectCount(Wrappers.<RepositoryEntity>lambdaQuery()
                .ne(RepositoryEntity::getId, repositoryId)
                .eq(RepositoryEntity::getSlug, slug)
                .eq(RepositoryEntity::getUserId, userId)) > 0;
    }

    public RepositoryEntity add(RepositoryEntity repository) {
        repository.setCreateAt(new Date());
        repository.setCreateBy(1L);
        repository.setUpdateAt(new Date());
        repository.setUpdateBy(1L);
        repository.setIsDeleted(false);
        super.save(repository);
        return repository;
    }
}
