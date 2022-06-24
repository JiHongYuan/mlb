package com.github.mlb.content.api.category.convert;

import com.github.mlb.content.api.category.entity.CategoryEntity;
import com.github.mlb.content.api.category.param.AddOrModifyCategoryParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author JiHongYuan
 * @date 2022/3/10 15:04
 */
@Mapper
public interface CategoryConvert {
    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    CategoryEntity toEntity(AddOrModifyCategoryParam param);

}
