package com.github.mlb.common.model;

import com.github.mlb.common.enums.QueueMessageEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author JiHongYuan
 * @date 2021/9/20 21:56
 */
@Getter
@Setter
public class QueueMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * message type
     */
    private QueueMessageEnum type;


    /**
     * data
     */
    private Serializable body;

}