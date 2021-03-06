package com.boot.bootdemo.service.impl;


import com.boot.bootdemo.service.MyFutureTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/7/27   20:42
 */
@Slf4j
@Service
public class FutureTaskImpl implements MyFutureTask {

    @Resource
    private ThreadPoolTaskExecutor testThreadPool;

    public String futureTask() throws InterruptedException, ExecutionException, TimeoutException {
        FutureTask<String> stringFutureTask=new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "哈哈哈哈哈";
            }
        });

        new Thread(stringFutureTask).start();
        try {
           return stringFutureTask.get(1000, TimeUnit.MILLISECONDS);
        }catch (TimeoutException e){
            log.info("捕获到了超时1秒异常{}",e.getMessage());
        }
        return "";
    }

    public String futureTaskDemo() {
        FutureTask<String> stringFutureTask=new FutureTask<>(() -> "哈哈哈哈哈");
        new Thread(stringFutureTask).start();

        try {
            return stringFutureTask.get(1000,TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.info("超时没拿到数据超时时间1000毫秒");
            e.printStackTrace();
        }
        return null;
    }

    public String futureTaskDemo(long time,long sleepTime) {
        // FutureTask<String> stringFutureTask=new FutureTask<>(() -> "哈哈哈哈哈");
        FutureTask<String> stringFutureTask=new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("哈哈哈哈哈哈哈");
                try {
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "哈哈哈";
            }
        });
        new Thread(stringFutureTask).start();

        try {
            return stringFutureTask.get(time,TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.info("time {}执行有问题了",time);
            e.printStackTrace();
        }
        return "超时了";
    }

    public String futureTaskLambda(long time,long sleepTime) {
        FutureTask<String> stringFutureTask=new FutureTask<>(() -> {
            System.out.println("哈哈哈哈哈哈哈");
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "哈哈哈";
        });
        new Thread(stringFutureTask).start();

        try {
            return stringFutureTask.get(time,TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.info("time {}执行有问题了",time);
            e.printStackTrace();
        }
        return "超时了";
    }

    public String futureTaskLambdaPool(long time,long sleepTime) {
        FutureTask<String> stringFutureTask=new FutureTask<>(() -> {
            System.out.println("哈哈哈哈哈哈哈");
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "哈哈哈";
        });
        testThreadPool.submit(stringFutureTask);

        try {
            return stringFutureTask.get(time,TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.info("time {}执行有问题了",time);
            e.printStackTrace();
        }
        return "超时了";
    }

    public String futureTaskPoolBack(long time,long sleepTime) {
        FutureTask<String> stringFutureTask=new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "哈哈哈";
        });

        Callable<String> callable = () -> "这是callable输出的";


        // new FutureTask<>()
        Future<String> submit = testThreadPool.submit(callable);

        try {
            String s = submit.get(time, TimeUnit.MILLISECONDS);
            System.out.println(s);
            return stringFutureTask.get(time,TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.info("time {}执行有问题了",time);
            e.printStackTrace();
        }
        return "超时了";
    }

    public String futureTaskPoolCallable(long time,long sleepTime) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFutureTask=new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "哈哈哈";
        });

        Future<String> submit1 = testThreadPool.submit(() -> "lambda call");
        System.out.println(submit1.get());

        Callable<String> callable = () -> "这是callable输出的";

        // new FutureTask<>()
        Future<String> submit = testThreadPool.submit(callable);

        try {

            String s = submit.get(time, TimeUnit.MILLISECONDS);
            System.out.println(s);
            return submit.get(time,TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.info("time {}执行有问题了",time);
            e.printStackTrace();
        }
        return "超时了";
    }

    public String test111(){
        testThreadPool.submit(()->{
            try {
                System.out.println("3秒开始");
                Thread.sleep(3000);
                System.out.println("3秒结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return "success";
    }

    public String test1111(){
        new Thread(()->{
            System.out.println("3秒开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3秒结束");
        }).start();
        return "success";
    }

}
