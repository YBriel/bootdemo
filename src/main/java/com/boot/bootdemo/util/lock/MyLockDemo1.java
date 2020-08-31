package com.boot.bootdemo.util.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
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
public class MyLockDemo1 {


    private static ConcurrentHashMap<String, LockObj> lockMap=new ConcurrentHashMap<>();

    private  static ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
    private  static Lock readLock= reentrantReadWriteLock.readLock();
    private static  Lock writeLock= reentrantReadWriteLock.writeLock();


    public void getLock(String key){

    }


  /*  public static boolean releaseLock(String key){

    }*/

    public static boolean putMap(String key){
        LockObj reentrantLock;
        LockObj lockObj = lockMap.get(key);
        if(lockObj==null){
            reentrantLock=new LockObj(key,true);
            try {
                boolean locked = writeLock.tryLock(3, TimeUnit.SECONDS);
                System.out.println(writeLock);
                if(locked){
                    log.info("上锁成功,key为{}",key);
                    if(lockMap.get(key)!=null){
                        log.info("锁被别的线程拿到了");
                        return false;
                    }else {
                        lockMap.put(key,reentrantLock);
                        log.info("添加成功{},当前锁数量为{}",key,lockMap.size());
                        return true;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                writeLock.unlock();
            }
        }else {
            if(lockObj.isFlag()){
                log.info("{}锁还是被锁了",key);
                return false;
            }
            log.info("{}锁被释放了",key);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入锁");
        while (!scanner.nextLine().contains("999")){
            String s = scanner.nextLine();
            boolean b = MyLockDemo1.putMap(s);
            System.out.println(b);
        }
    }
}
