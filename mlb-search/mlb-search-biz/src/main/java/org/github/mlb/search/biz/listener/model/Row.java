package org.github.mlb.search.biz.listener.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author JiHongYuan
 * @date 2021/9/21 14:52
 */
@Getter
@Setter
public class Row {
    private Serializable id;
    private Map<String, Object> data;

    public Row(Serializable id, Map<String, Object> data) {
        this.id = id;
        this.data = data;
    }

}