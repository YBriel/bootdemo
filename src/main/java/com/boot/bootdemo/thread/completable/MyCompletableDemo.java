package com.boot.bootdemo.thread.completable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * author: yuzq
 * create: 2021-04-02 15:40
 **/
@Slf4j
public class MyCompletableDemo {


    public String sayHello(){
        log.info("你好...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }


    public Integer guess(){
        log.info("你好猜一下...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public void test(){
        log.info("这个是打印...");
    }


    public CompletableFuture<String> sayHelloFuture() {
        return CompletableFuture.supplyAsync(this::sayHello);
    }

    public CompletableFuture<Integer> guessFuture() {
        return CompletableFuture.supplyAsync(this::guess);
    }

    public static void main(String[] args) {
        long time=System.currentTimeMillis();
        MyCompletableDemo demo=new MyCompletableDemo();
        demo.sayHello();
        demo.guess();
        log.info("两步耗时{}",System.currentTimeMillis()-time);

        long time2=System.currentTimeMillis();
        CompletableFuture<String> stringCompletableFuture = demo.sayHelloFuture();
        CompletableFuture<Integer> integerCompletableFuture = demo.guessFuture();
        boolean done = CompletableFuture.allOf(stringCompletableFuture, integerCompletableFuture).isDone();
        if(done){
           // stringCompletableFuture.get();
        }
        CompletableFuture.allOf(stringCompletableFuture,integerCompletableFuture).thenRun(() -> System.out.println("完成！！！！")).join();
        log.info("两步耗时{}",System.currentTimeMillis()-time2);
    }
}
