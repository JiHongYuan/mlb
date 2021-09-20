package com.github.mlb.content.biz.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:38
 */

@Getter
@Setter
@TableName("b_content_repository")
public class RepositoryEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String repositoryName;

    private String desc;

    private String descImgPath;

    private Boolean isPublic;

}
