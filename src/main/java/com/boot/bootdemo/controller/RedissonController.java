package com.boot.bootdemo.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/7/14   20:51
 */
@RestController
public class RedissonController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/testC")
    public void testC(){

        this.common(4);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                this.common(2);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(this::commonDemo, String.valueOf(i)).start();
        }
/*       new Thread(() -> this.common(2), "BB").start();

        new Thread(() -> this.common(2), "CC").start();

        new Thread(() -> this.common(2), "DD").start();*/

    }

    private void common(Integer time){
        System.out.println(Thread.currentThread().getName()+"开始执行");
/*        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //RLock lock = redissonClient.getLock("anyLock");
        RLock lock = redissonClient.getFairLock("anyLock");
        while (lock.isLocked()){
            System.out.println("被锁了");
    /*        try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        try {
            lock.lock();
            //Future<Boolean> res = lock.tryLockAsync(1, 2, TimeUnit.SECONDS);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RBucket<String> locktest = redissonClient.getBucket("locktest", StringCodec.INSTANCE);
            System.out.println(locktest.get());
            if(!StringUtils.isEmpty(locktest.get())){
                lock.unlock();
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"执行结束");
        }
    }

    private void commonDemo(){
        System.out.println(Thread.currentThread().getName()+"开始执行");
        RLock lock = redissonClient.getFairLock("common");
        while (lock.isLocked()){
            System.out.println("被锁了");

        }
        try {
            lock.lock();
            RBucket<String> locktest = redissonClient.getBucket("localde", StringCodec.INSTANCE);
            System.out.println(locktest.get());
            if(!StringUtils.isEmpty(locktest.get())){
                lock.unlock();
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"执行结束");
        }
    }

}
