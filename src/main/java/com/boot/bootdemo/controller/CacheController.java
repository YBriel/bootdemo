package com.boot.bootdemo.controller;

import com.boot.bootdemo.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2020-09-20 11:45
 **/
@RestController
public class CacheController {


    @Autowired
    private CacheService cacheService;


    @RequestMapping("/test")
    public String get(String name){
    return cacheService.get(name);
    }
}
