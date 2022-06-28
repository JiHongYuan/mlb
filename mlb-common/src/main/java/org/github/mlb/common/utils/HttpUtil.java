package org.github.mlb.common.utils;

import java.util.function.Function;

/**
 * @author JiHongYuan
 * @date 2021/9/22 14:52
 */
public class HttpUtil {

    public static <T> T apply(T repository, Function<T, Result<T>> function) {
        try {
            Result<T> result = function.apply(repository);
            if (result != null && result.isSuccess() && result.getData() != null) {
                return result.getData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
