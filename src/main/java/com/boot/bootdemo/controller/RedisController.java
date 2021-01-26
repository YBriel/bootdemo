package com.boot.bootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * author: yuzq
 * create: 2020-06-18 18:53
 **/
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate1;

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

    @RequestMapping("insert")
    public void test(){
        redisTemplate.opsForList().rightPushAll("demo", Arrays.asList("1","23","3","231","22","31","55","66","77","88"));
    }

    @RequestMapping("pop")
    public void get(){
        String s = redisTemplate.opsForList().leftPop("demo");
        if(StringUtils.isEmpty(s)){
            System.out.println("没找到数据");
            return;
        }
        System.out.println(s);
    }

    @RequestMapping("pop1")
    public void getThread(){
        new Thread(()->{
            String s = redisTemplate.opsForList().leftPop("demo");
            if(StringUtils.isEmpty(s)){
                System.out.println("0---------没找到数据");
                return;
            }
            System.out.println("0-------"+s);
        }).start();

        new Thread(()->{
            String s = redisTemplate1.opsForList().leftPop("demo");
            if(StringUtils.isEmpty(s)){
                System.out.println("1=========没找到数据");
                return;
            }
            System.out.println("1======"+s);
        }).start();
    }
}
