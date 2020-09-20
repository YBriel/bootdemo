package com.boot.bootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2020-09-20 11:42
 **/
@CacheConfig(cacheNames="user")// cacheName 是一定要指定的属性，可以通过 @CacheConfig 声明该类的通用配置
@Service
@Slf4j
public class CacheService {

    private static Map<String,String> map=new HashMap<>();

    static {
        map.put("tom","231");
        map.put("tom1","22qeq331");
        map.put("tom2","we");
        map.put("tom3","r");
        map.put("tom4","df");
    }

    @Cacheable(key = "#name")
    public String get(String name){
        log.info("查询了数据库...");
        return map.get(name);
    }


}
