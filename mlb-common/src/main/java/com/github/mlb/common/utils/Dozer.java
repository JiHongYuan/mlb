package com.github.mlb.common.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dozer {
    private Dozer() {
    }

    private static final Mapper MAPPER = new DozerBeanMapper();

    public static <T> T convert(Object source, Class<T> destinationClass) {
        if (source == null) return null;

        return MAPPER.map(source, destinationClass);
    }

    public static <T> List<T> convert(List<?> source, Class<T> destinationClass) {
        if (source == null) return Collections.emptyList();
        List<T> dataList = new ArrayList<>();
        for (Object o : source) {
            dataList.add(MAPPER.map(o, destinationClass));
        }
        return dataList;
    }

}