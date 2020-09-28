package com.boot.bootdemo.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2020-09-17 10:44
 **/
@Service
public class MyCacheService {

    private static Map<String,String> map=new HashMap<>();

    static {
        map.put("tom","hh");
        map.put("tom2","hh1");
        map.put("tom3","hh2");
        map.put("tom4","hh3");
    }

    @Cacheable(cacheManager = "cacheManager",key ="#name" ,value = "cache-1")
    public String findUserById(String name){
        return map.get(name);
    }
}
