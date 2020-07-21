package com.boot.bootdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: yuzq
 * create: 2020-05-18 09:57
 **/
public class ThreadDemo1 {

    public static void main(String[] args) throws InterruptedException {

      /*  System.out.println("执行开始！");

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println("哈哈哈;");
            int a=1/0;
        });
        executorService.shutdown();

        Thread.sleep(5000);
        System.out.println("bbb");*/

        long nowTime =System.currentTimeMillis();
        long todayStartTime =nowTime - ((nowTime + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000L));
        Date date=new Date(todayStartTime);

    }
}
