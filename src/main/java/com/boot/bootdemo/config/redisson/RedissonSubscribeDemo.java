package com.boot.bootdemo.config.redisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonBlockingQueue;
import org.redisson.api.*;
import org.redisson.api.listener.MessageListener;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * author: yuzq
 * create: 2021-05-21 09:22
 **/
@Slf4j
@Component
public class RedissonSubscribeDemo {

    @Autowired
    private RedissonClient redissonClient;


    @PostConstruct
    public void  subscribe(){

        RTopic testPubSub = redissonClient.getTopic("testPubSub", StringCodec.INSTANCE);
        testPubSub.addListener(String.class, (channel, msg) -> {
            log.info("收到消息去更新channel{}===msg{}",channel,msg);
        });
    }

    @PostConstruct
    public void  subscribe1(){
        RTopic testPubSub = redissonClient.getTopic("testPubSub", StringCodec.INSTANCE);
        testPubSub.addListener(String.class, (channel, msg) -> {
            log.info("收到消息去修改channel{}===msg{}",channel,msg);
        });
    }



}
