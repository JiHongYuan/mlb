package com.github.mlb.content.api.repository.params;

import com.github.mlb.common.utils.AddOperate;
import com.github.mlb.common.utils.ModifyOperate;
import lombok.Getter;
import lombok.Setter;
import org.dozer.Mapping;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author JiHongYuan
 * @date 2021/9/18 14:44
 */
@Getter
@Setter
public class AddOrModifyRepositoryParam {

    @Mapping("id")
    @Null(groups = {AddOperate.class})
    @NotNull(groups = {ModifyOperate.class})
    private Integer repositoryId;

    /**
     * 仓库名称
     */
    @NotEmpty
    private String repositoryName;

    /**
     * 简介
     */
    private String desc;

    /**
     * 简介图片
     */
    private String descImgPath;

    /**
     * 是否公开
     */
    private Boolean isPublic;

}