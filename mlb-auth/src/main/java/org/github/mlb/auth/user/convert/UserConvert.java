package org.github.mlb.auth.user.convert;

import org.github.mlb.auth.model.GitHubUserInfo;
import org.github.mlb.common.model.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author JiHongYuan
 * @date 2022/3/7 10:59
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mapping(source = "login", target = "name")
    @Mapping(source = "id", target = "access")
    UserInfo toUserInfo(GitHubUserInfo userInfo);

}