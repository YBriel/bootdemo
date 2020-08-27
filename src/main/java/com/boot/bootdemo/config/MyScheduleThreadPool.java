package com.boot.bootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * author: yuzq
 * create: 2020-08-27 14:21
 **/
@Configuration
@Component
public class MyScheduleThreadPool {

    @Bean
    public ScheduledThreadPoolExecutor scheduledThreadPoolExecutor(){
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        executor.setMaximumPoolSize(10);
        return executor;
    }
}


