package com.github.mlb.content.biz.repository.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mlb.content.biz.repository.mapper.RepositoryMapper;
import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import org.springframework.stereotype.Component;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:40
 */
@Component
public class RepositoryManager extends ServiceImpl<RepositoryMapper, RepositoryEntity> {
}
