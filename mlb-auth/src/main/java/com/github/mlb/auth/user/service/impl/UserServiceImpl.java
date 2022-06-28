package com.github.mlb.auth.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mlb.auth.user.entity.UserEntity;
import com.github.mlb.auth.user.mapper.UserMapper;
import com.github.mlb.auth.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author JiHongYuan
 * @date 2022/1/21 11:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public UserEntity getByAccess(String access) {
        return super.getOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getAccess, access));
    }

}
