package com.boot.bootdemo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/13   22:13
 */
@Configuration
@ComponentScan({"com.boot.bootdemo.service","com.boot.bootdemo.mapper"})
public class RedissonConfig {

    @Bean
    public RedissonClient red() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://39.106.121.52:6379");
        //config.useSingleServer().setPassword("mz666");
        return Redisson.create(config);
    }
}
