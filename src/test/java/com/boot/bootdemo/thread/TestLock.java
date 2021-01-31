package com.boot.bootdemo.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.test.annotation.Repeat;

/**
 * author: yuzq
 * create: 2021-01-17 11:04
 **/
@Slf4j
public class TestLock {

    @Test
    @Repeat(20)
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
        log.info("当前线程{}",Thread.currentThread().getName());
        a.start();
        a.join();
        log.info("当前线程{}",Thread.currentThread().getName());
       // Thread.sleep(1000L);
      //  a.join();
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
       // log.info("当前线程{}",Thread.currentThread().getName());
        try {
     //       log.info("当前线程{}",Thread.currentThread().getName());
            Thread.sleep(2000L);
            //Thread.currentThread().wait(2000);
            Thread thread = Thread.currentThread();
          //  log.info("当前线程{}",Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("结束执行");
    }
}
