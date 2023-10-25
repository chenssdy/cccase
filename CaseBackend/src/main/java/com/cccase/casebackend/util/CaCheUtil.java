package com.cccase.casebackend.util;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CaCheUtil {

    // 创建一个 ConcurrentHashMap 用于缓存数据
    private final Map<String, String> cache = new ConcurrentHashMap<>();

    public String getData(String key) {
        // 先尝试从缓存中获取数据
        String cachedData = cache.get(key);

        if (cachedData != null) {
            // 如果缓存中有数据，直接返回
            return cachedData;
        } else {
            // 如果缓存中没有数据

            return "null";
        }
    }

    public void remove(String key){
        cache.remove(key);
    }

    public void setData(String key, String str){
        cache.put(key, str);
    }

}
