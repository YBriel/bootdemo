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
 * author: yuzq
 * create: 2020-07-20 14:17
 **/
@RequestMapping("/redisson")
@RestController
public class RedissonLock1Controller {
    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/get1")
    public String getFairLock(String key,Integer time){
        RLock lock = redissonClient.getFairLock(key);
        try {
            lock.lock();
            //Future<Boolean> res = lock.tryLockAsync(1, 2, TimeUnit.SECONDS);
            try {
                TimeUnit.SECONDS.sleep(time);
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
        return "get1 success";
    }

    @RequestMapping("/getLock")
    public String getLock(Integer waitTime,String key,Integer time){
        RLock lock = redissonClient.getLock(key);

        try {
            try {
                lock.tryLock(waitTime,time,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep((time-1)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Future<Boolean> res = lock.tryLockAsync(1, 2, TimeUnit.SECONDS);
            RBucket<String> locktest = redissonClient.getBucket("locktest", StringCodec.INSTANCE);
            System.out.println(locktest.get());
            if(!StringUtils.isEmpty(locktest.get())){
                lock.unlock();
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"执行结束");
        }
        return "get1 success";
    }

    @RequestMapping("/update2")
    public String update2(String key,Integer time){
        RLock lock = redissonClient.getFairLock(key);
        try {
            lock.lock();
            //Future<Boolean> res = lock.tryLockAsync(1, 2, TimeUnit.SECONDS);
            try {
                TimeUnit.SECONDS.sleep(time);
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
        return "update2 success";
    }

    @RequestMapping("/update3")
    public String update3(String key,Integer time){
        RLock lock = redissonClient.getFairLock(key);
        try {
            lock.lock();
            //Future<Boolean> res = lock.tryLockAsync(1, 2, TimeUnit.SECONDS);
            try {
                TimeUnit.SECONDS.sleep(time);
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
        return "update3 success";
    }
}
