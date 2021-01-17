package com.boot.bootdemo.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * author: yuzq
 * create: 2021-01-17 11:04
 **/
@Slf4j
public class TestLock {

    @Test
    public void blockedTest() throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        Thread.sleep(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            log.info("开始执行");
            Thread.sleep(2000L);
            log.info("开始执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
