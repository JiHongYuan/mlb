package com.github.mlb.content.api.category.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.mlb.common.model.BaseEntity;
import com.github.mlb.content.api.category.enums.CategoryType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author JiHongYuan
 * @date 2021/9/18 10:24
 */
@Getter
@Setter
@TableName("b_content_category")
public class CategoryEntity extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long repositoryId;

    /**
     * 路径名称
     */
    private String slug;

    /**
     * 分类标题
     */
    private String title;

    /**
     * 类型(1:title;2:doc)
     */
    private CategoryType type;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 前驱节点
     */
    private Long prevId;

    /**
     * 后驱节点
     */
    private Long nextId;

    /**
     * 父亲节点
     */
    private Long parentId;

}