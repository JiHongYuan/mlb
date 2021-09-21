package com.github.mlb.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/20 7:33
 */
@Getter
@Setter
@ToString
public class BinlogDTO implements Serializable {
    private Long tableId;
    private String database;
    private String table;
    private String eventAction;
    private List<Serializable[]> rows;
}
