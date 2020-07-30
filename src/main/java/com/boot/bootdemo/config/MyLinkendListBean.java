package com.boot.bootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * author: yuzq
 * create: 2020-07-30 10:15
 **/
//@Configuration
public class MyLinkendListBean {

    //@Resource
    private ThreadPoolTaskExecutor testThreadPool;

    //@PostConstruct
    public void linkedListConfig(){
        testThreadPool.submit(new MyLinkedListConfig());
    }
}
