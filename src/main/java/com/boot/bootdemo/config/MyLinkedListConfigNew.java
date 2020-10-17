package com.boot.bootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: yuzq
 * create: 2020-07-30 09:36
 **/
@Slf4j
@Component
public class MyLinkedListConfigNew implements Runnable {

    public static LinkedListDemo linkedListDemo=new LinkedListDemo(5);

    //private volatile static AtomicInteger size=new AtomicInteger(0);
    public volatile static AtomicInteger size=new AtomicInteger(0);
    public volatile static boolean overSize=size.get()>=4;

  //  public volatile boolean overTime=System.currentTimeMillis()-linkedListDemo.getTriggerTime()>=6000;
    public static void  queue(Long item){
        log.info("before added  {} ,the queue size is new {},size.get(){},overSize{}",item,linkedListDemo.getBlockingQueue().size(),size.get(),overSize);
        linkedListDemo.getBlockingQueue().add(item);
        size.getAndIncrement();
        log.info("after added {} ,the queue size is new {},size.get(){},overSize{}",item,linkedListDemo.getBlockingQueue().size(),size.get(),overSize);

    }

    @Resource
    private ThreadPoolTaskExecutor testThreadPool;

    @Override
    public void run() {
        long resetTime = System.currentTimeMillis();
        log.info("monitor program started.... restTime is {}", resetTime);
        //linkedListDemo.getBlockingQueue().size()+1>=linkedListDemo.getListSize() || System.currentTimeMillis()-resetTime>linkedListDemo.getTriggerTime()
        log.info("initial size{}",linkedListDemo.getBlockingQueue().size());
            while (size.get() >= 4){
                resetTime = System.currentTimeMillis();
                log.info("linkedListDemo.getBlockingQueue().size(){}>=linkedListDemo.getListSize(){} ", linkedListDemo.getBlockingQueue().size() + 1, linkedListDemo.getListSize());
                log.info("info getBlockingQueue {} ,getListSize {},currentTimeMillis {}, getTriggerTime {}", linkedListDemo.getBlockingQueue().size(), linkedListDemo.getListSize(), System.currentTimeMillis(), linkedListDemo.getTriggerTime());
                log.info("the queue size is {}", size.get());
                log.info("pretend post data to big data  restTime reset{}", resetTime);
                linkedListDemo.getBlockingQueue().clear();
                log.info("queue size empty success");
                log.info("the queue size after is {}", linkedListDemo.blockingQueue.size());
            }
            log.info("陶子凡是傻逼");
    }

    @PostConstruct
    public void runTask(){
        log.info("task submitted");
        testThreadPool.submit(this);
    }
}
