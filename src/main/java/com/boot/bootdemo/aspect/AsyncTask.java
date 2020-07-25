package com.boot.bootdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-07-24 10:05
 **/
@Component
@Slf4j
public class AsyncTask {

    @Async
    public void test() throws InterruptedException {
        System.out.println("执行开始--------");
        Thread.sleep(5000);
        System.out.println("执行结束--------");
    }

}
