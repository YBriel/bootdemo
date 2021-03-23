package com.boot.bootdemo.config;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * author: yuzq
 * create: 2021-03-23 14:04
 **/
@Slf4j
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.info("丢弃任务{}",r.toString());
    }
}
