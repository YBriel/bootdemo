package com.boot.bootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2020-06-18 18:53
 **/
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/testRedis")
    public void testRedis(){
        String s1 = redisTemplate.opsForList().leftPop("demo");
        System.out.println(redisTemplate.hashCode());
        System.out.println("这是:"+s1);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                String s = redisTemplate.opsForList().leftPop("demo");
                System.out.println(s);
                System.out.println(redisTemplate.hashCode());
            },i+"--").start();
        }
    }


}
