package com.boot.bootdemo.config.redisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * author: yuzq
 * create: 2021-05-21 09:22
 **/
@Slf4j
@Component
public class RedissonPublishDemo {

    @Autowired
    private RedissonClient redissonClient;


    public void  publish(String content){
        RTopic testPubSub = redissonClient.getTopic("testPubSub", StringCodec.INSTANCE);
        testPubSub.publish(content);
        log.info("发送消息完毕{}",content);
    }
}
