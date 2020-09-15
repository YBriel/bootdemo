package com.boot.bootdemo.thread.locksupport;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * author: yuzq
 * create: 2020-09-11 09:43
 **/
public class LockSupportDemo {

    public static void main(String[] args) {
        Map<String,Thread> map=new HashMap<>();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            map.put("t1",Thread.currentThread());
            System.out.println("hello");
            System.out.println("停止了...");
            LockSupport.park();
        },"aaa").start();
        boolean flag=true;
        while (flag){
            while (map.get("t1")!=null){
                System.out.println("解封线程...");
                Thread thread = map.get("t1");
                LockSupport.unpark(map.get("t1"));
                System.out.println("继续运行...");
                flag=false;
            }
        }

    }
}
