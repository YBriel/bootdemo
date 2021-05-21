package com.boot.bootdemo.config.redisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
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
public class RedissonPublishDemo {

    @Autowired
    private RedissonClient redissonClient;


    public void  publish(String content){
        RTopic testPubSub = redissonClient.getTopic("testPubSub", StringCodec.INSTANCE);
        testPubSub.publish(content);
        log.info("发送消息完毕{}",content);
    }

    public void delayQueue(String content,long delay){
        RBlockingQueue<String> blockingQueue = redissonClient.getBlockingQueue("dest_queue1",StringCodec.INSTANCE);
        RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
        delayedQueue.offer(content,delay, TimeUnit.SECONDS);
        log.info("发送延迟队列消息完毕{}",content);
        delayedQueue.destroy();
    }

    @PostConstruct
    public void init() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // 每秒检测一次
        log.info("每秒执行一次监听队列");
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                RQueue<String> queue = redissonClient
                        .getQueue("dest_queue1");
                String promotionId = queue.poll();
                // 有促销ID，则进行起价更新
                if (!StringUtils.isEmpty(promotionId)) {
                    log.info("延迟队列收到消息{}",promotionId);
                }/*else {
                    log.info("是空的数据");
                }*/
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
