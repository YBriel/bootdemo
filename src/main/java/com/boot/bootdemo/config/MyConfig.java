package com.boot.bootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: yuzq
 * create: 2020-10-21 09:20
 **/
@Component
@Slf4j
public class MyConfig {

    private static Map<String,String> map=new HashMap<>();

    public static final Map<String,String> map2=new ConcurrentHashMap<>(); //存md5和信息



    static {
        map.put("name","tom");
        log.info("配置初始化成功....");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static void setMap(Map<String, String> map) {
        MyConfig.map = map;
    }



}
