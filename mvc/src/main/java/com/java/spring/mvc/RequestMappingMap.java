package com.java.spring.mvc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author renqingwang on 2018/4/1.
 * @version 1.0
 */
public class RequestMappingMap {
    private static Map<String, Class<?>> requestMap = new HashMap<String, Class<?>>();

    public static Class<?> getClassName(String path) {
        return requestMap.get(path);
    }

    public static void put(String path, Class<?> className) {
        requestMap.put(path, className);
    }

    public static Map<String, Class<?>> getRequestMap() {
        return requestMap;
    }
}
