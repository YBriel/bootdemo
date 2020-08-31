package com.boot.bootdemo.util.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author: yuzq
 * create: 2020-08-22 21:06
 **/
@Slf4j
public class MyLock {


    private ConcurrentHashMap<String, ReentrantLock> lockMap=new ConcurrentHashMap<>();

    private static volatile ReentrantReadWriteLock reentrantReadWriteLock;
    private static final Lock readLock= reentrantReadWriteLock.readLock();
    private static final Lock writeLock= reentrantReadWriteLock.writeLock();


    public void getLock(String key){

    }


    public ReentrantLock getMap(String key){
        try {
            readLock.tryLock(5,TimeUnit.SECONDS);
            log.info("锁获取成功,当前有{}个锁",lockMap.size());
            ReentrantLock reentrantLock = lockMap.get(key);
            lockMap.remove(key);
            return reentrantLock;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
        return null;
    }

    public void putMap(String key,ReentrantLock reentrantLock){
        try {
            writeLock.tryLock(5, TimeUnit.SECONDS);
            if(lockMap.get(key)!=null){
                log.info("当前key {},已被锁,添加失败",key);
                return;
            }
            lockMap.put(key,reentrantLock);
            log.info("数据放入成功,当前有{}个锁",lockMap.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }
}
