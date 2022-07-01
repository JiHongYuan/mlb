package org.github.mlb.content.biz.repository.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.mlb.common.model.UserInfo;
import org.github.mlb.common.utils.JwtUtil;
import org.github.mlb.common.utils.UserHolder;
import org.github.mlb.content.repository.param.QueryRepositoryParam;
import org.github.mlb.content.biz.repository.mapper.RepositoryMapper;
import org.github.mlb.content.repository.entity.RepositoryEntity;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:40
 */
@Component
@AllArgsConstructor
public class RepositoryManager extends ServiceImpl<RepositoryMapper, RepositoryEntity> {
    private final RepositoryMapper repositoryMapper;
    private final RedissonClient redissonClient;

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

    public Page<RepositoryEntity> selectPageByParam(IPage<?> page, QueryRepositoryParam param) {
        return repositoryMapper.selectPageByParam(page, param);
    }

    public List<Long> selectListIdByUserId(Long userId) {
        return repositoryMapper.selectListIdByUserId(userId);
    }

    /**
     * 删除 {@code repositoryId}
     *
     * @param repositoryId 仓库ID
     */
    public void deleteRepositoryById(Long repositoryId) {
        repositoryMapper.deleteById(repositoryId);
        UserHolder.get().getRepositories().remove(repositoryId);
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
        super.save(repository);
        UserHolder.get().getRepositories().add(repository.getId());
        return repository;
    }

}
