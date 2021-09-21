package com.github.mlb.search.biz.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author JiHongYuan
 * @date 2021/9/18 15:44
 */

@Getter
@Setter
@Document(indexName = "mlb-content.b_content_repository")
public class RepositoryDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Integer)
    private Integer userId;

    @Field(type = FieldType.Text)
    private String repositoryName;

    @Field(type = FieldType.Keyword)
    private String desc;

    @Field(type = FieldType.Text)
    private String descImgPath;

    @Field(type = FieldType.Integer)
    private Integer isPublic;

}