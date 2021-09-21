package com.github.mlb.search.biz.article.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:14
 */

@Getter
@Setter
@Document(indexName = "article")
public class ArticleDocument {

    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Keyword)
    private String content;

}