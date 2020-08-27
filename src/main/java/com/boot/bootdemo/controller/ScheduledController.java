package com.boot.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping("test1")
    public String test1(Long time){
        log.info("收到调度{}",new Date());
        myScheduleThreadPool.schedule(() -> {
            log.info("执行任务了{}",new Date());
        },time, TimeUnit.SECONDS);
        return "success";
    }
}
