package com.boot.bootdemo.config;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/6/14   20:40
 */
//@Configuration
public class MyRedisTemplate {
   // @Bean
    public StringRedisTemplate redisTemplate(){
        return new StringRedisTemplate();
    }
}
