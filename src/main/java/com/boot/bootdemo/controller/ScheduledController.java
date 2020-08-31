package com.boot.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.GeoEntry;
import org.redisson.api.RGeo;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author: yuzq
 * create: 2020-08-27 14:30
 **/
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduledController {

    @Autowired
    private ScheduledThreadPoolExecutor myScheduleThreadPool;

    @Autowired
    RedissonClient redissonClient;

    @RequestMapping("test1")
    public String test1(Long time){
        RGeo<String> geo = redissonClient.getGeo("test1",StringCodec.INSTANCE);
        long l = System.currentTimeMillis();
        String s = "nantian" + l;
        geo.add(new GeoEntry(111.838936,28.741351,s));
        log.info("收到调度{}",new Date());
        myScheduleThreadPool.schedule(() -> {
            geo.remove(s);
            log.info("执行删除redis任务了{}",new Date());
        },time, TimeUnit.SECONDS);
        return "success";
    }
}
