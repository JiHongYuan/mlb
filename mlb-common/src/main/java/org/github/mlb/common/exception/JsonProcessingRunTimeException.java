package org.github.mlb.common.exception;

/**
 * @author jihongyuan
 * @date 2020/7/13 17:07
 */
public class JsonProcessingRunTimeException extends RuntimeException {
    public JsonProcessingRunTimeException(Exception exception) {
        super(exception);
    }
}
