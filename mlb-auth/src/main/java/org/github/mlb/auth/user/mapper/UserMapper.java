package org.github.mlb.auth.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.github.mlb.auth.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author JiHongYuan
 * @date 2022/1/21 11:23
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
}