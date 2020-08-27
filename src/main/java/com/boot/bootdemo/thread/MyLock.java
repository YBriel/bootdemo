package com.boot.bootdemo.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author: yuzq
 * create: 2020-08-22 17:15
 **/
@Slf4j
public class MyLock {

    private static volatile ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();

    private static volatile ConcurrentHashMap<String,ReentrantReadWriteLock> lockConcurrentHashMap=new ConcurrentHashMap<>();

    private static ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();

    public void getLock(String key){

        if(StringUtils.isEmpty(map.get(key))){
            reentrantReadWriteLock.writeLock();
            log.info("写锁开始了");
            try {
                log.info("开始休眠");
                Thread.sleep(3000);
                log.info("休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
