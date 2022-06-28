package org.github.mlb.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jihongyuan
 * @date 2022/6/26 11:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo implements Serializable {
    private Integer size;
    private Integer index;

}
