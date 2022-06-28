package org.github.mlb.content.api.article.convert;

import org.github.mlb.content.api.article.entity.ArticleEntity;
import org.github.mlb.content.api.article.param.AddArticleParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jihongyuan
 * @date 2022/6/28 9:10
 */
@Mapper
public interface ArticleConvert {

    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    ArticleEntity toEntity(AddArticleParam param);

}
