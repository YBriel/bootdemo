package com.boot.bootdemo.config;

import com.boot.bootdemo.designpattern.strategy.MyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * author: yuzq
 * create: 2020-07-25 14:13
 **/
@Configuration
@Component
public class MyThreadPoolConfig {

    @Bean(name = "myScheduledThreadPoolExecutor")
    @Primary
    public ScheduledThreadPoolExecutor myScheduledThreadPoolExecutor(){
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        executor.setMaximumPoolSize(10);
        executor.setRejectedExecutionHandler(new MyRejectedExecutionHandler());
        //executor.setKeepAliveTime();
        return executor;
    }

    @Bean(name = "testThreadPool")
    public Executor testThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);  //核心线程
        executor.setMaxPoolSize(4); //最大线程
        executor.setQueueCapacity(11);  //队列容量
        executor.setKeepAliveSeconds(10);  //最大存活时间
        executor.setThreadNamePrefix("testThreadPool-"); //线程名
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy()); //拒绝直接丢弃策略
        executor.setWaitForTasksToCompleteOnShutdown(true);
       // executor.setAwaitTerminationSeconds(10);
       // executor.setAllowCoreThreadTimeOut(true); //设置核心线程到时关闭
        executor.initialize();
        return executor;
    }
    @Bean(name = "threadPoolExp")
    public Executor threadPoolExp() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);  //核心线程
        executor.setMaxPoolSize(4); //最大线程
        executor.setQueueCapacity(11);  //队列容量
        executor.setKeepAliveSeconds(10);  //最大存活时间
        executor.setThreadNamePrefix("threadPoolExp-"); //线程名
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy()); //拒绝直接丢弃策略
        executor.setWaitForTasksToCompleteOnShutdown(true);

        // System.out.println(aClass);
        // executor.setAwaitTerminationSeconds(10);
        // executor.setAllowCoreThreadTimeOut(true); //设置核心线程到时关闭
        executor.initialize();
        ThreadPoolExecutor threadPoolExecutor = executor.getThreadPoolExecutor();
        ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
        threadPoolExecutor.setThreadFactory(new MyThreadFactory());
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello my friend");
            }
        });
        return executor;
    }


}
