package com.github.mlb.content.api.repository.convert;

import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import com.github.mlb.content.api.repository.param.AddOrModifyRepositoryParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author JiHongYuan
 * @date 2022/1/21 14:49
 */
@Mapper
public interface RepositoryConvert {
    RepositoryConvert INSTANCE = Mappers.getMapper(RepositoryConvert.class);

    /**
     * {@code param} to RepositoryEntity
     *
     * @param param request param
     * @return convert
     */
    RepositoryEntity toEntity(AddOrModifyRepositoryParam param);

}
