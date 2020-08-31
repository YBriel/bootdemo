package com.boot.bootdemo.util.lock;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author: yuzq
 * create: 2020-08-22 21:22
 **/
@Data
public class LockObj {
    private static  ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
    private String name;
    private boolean flag;
    private static final Lock readLock= reentrantReadWriteLock.readLock();
    private static final Lock writeLock= reentrantReadWriteLock.writeLock();

    public LockObj(String name, boolean flag) {
        this.name = name;
        this.flag = flag;
    }
}
