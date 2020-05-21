package com.boot.bootdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: yuzq
 * create: 2020-05-18 09:57
 **/
public class ThreadDemo1 {

    public static void main(String[] args) {

        System.out.println("执行开始！");

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println("哈哈哈;");
            int a=1/0;
        });


        System.out.println("bbb");
    }
}
