package com.boot.bootdemo.aspect;

import java.util.concurrent.Callable;

/**
 * author: yuzq
 * create: 2020-07-29 17:25
 **/
public class AsyncTest implements Callable<String> {

    public void testWait(){
        System.out.println("开始执行");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束执行");
    }

    @Override
    public String call() throws Exception {
        this.testWait();
        return "结束执行了";
    }
}
