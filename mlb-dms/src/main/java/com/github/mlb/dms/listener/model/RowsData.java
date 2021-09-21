package com.github.mlb.dms.listener.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/20 7:19
 */
@Getter
@Setter
public class RowsData {
    private long tableId;
    private List<Serializable[]> rows;
}
