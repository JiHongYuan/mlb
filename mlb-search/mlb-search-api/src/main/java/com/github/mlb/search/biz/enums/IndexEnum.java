package com.github.mlb.search.biz.enums;

import com.github.mlb.search.biz.repository.entity.RepositoryDocument;
import lombok.Getter;
import org.springframework.lang.Nullable;

/**
 * @author JiHongYuan
 * @date 2021/9/21 14:35
 */
@Getter
public enum IndexEnum {

    /**
     * 仓库
     */
    REPOSITORY_INDEX("mlb-content.b_content_repository", RepositoryDocument.class),
    ;


    private final String index;
    private final Class<?> clazz;

    IndexEnum(String index, Class<?> clazz) {
        this.index = index;
        this.clazz = clazz;
    }

    @Nullable
    public static IndexEnum get(String index) {
        for (IndexEnum indexEnum : IndexEnum.values()) {
            if (indexEnum.getIndex().equals(index)) {
                return indexEnum;
            }
        }
        return null;
    }
}
