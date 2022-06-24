package com.github.mlb.content.api.category.param;

import lombok.Getter;
import lombok.Setter;

/**
 * @author JiHongYuan
 * @date 2022/3/10 14:45
 */
@Getter
@Setter
public class AddOrModifyCategoryParam {

    private Long categoryId;

    /**
     * 仓库ID
     */
    private Long repositoryId;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型
     */
    private String type;

    /**
     * 父节点
     */
    private Long parentId;

}
