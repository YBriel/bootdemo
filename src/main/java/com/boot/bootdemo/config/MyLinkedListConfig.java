package com.boot.bootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * author: yuzq
 * create: 2020-07-30 09:36
 **/
@Slf4j
@Component
public class MyLinkedListConfig implements Runnable {

    public static LinkedListDemo linkedListDemo=new LinkedListDemo(5);

    public static void  queue(Long item){
        linkedListDemo.getBlockingQueue().add(item);
        log.info("added {} ,the queue size is {}",item,linkedListDemo.getBlockingQueue().size());
    }

    @Resource
    private ThreadPoolTaskExecutor testThreadPool;

    @Override
    public void run() {
        long resetTime = System.currentTimeMillis();
        log.info("monitor program started.... restTime is {}", resetTime);
        //linkedListDemo.getBlockingQueue().size()+1>=linkedListDemo.getListSize() || System.currentTimeMillis()-resetTime>linkedListDemo.getTriggerTime()
        log.info("initial size{}",linkedListDemo.getBlockingQueue().size());
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (linkedListDemo.getBlockingQueue().size()>=linkedListDemo.getListSize() || System.currentTimeMillis()- resetTime >linkedListDemo.getTriggerTime()){
                resetTime =System.currentTimeMillis();
                log.info("linkedListDemo.getBlockingQueue().size(){}>=linkedListDemo.getListSize(){} ",linkedListDemo.getBlockingQueue().size()+1,linkedListDemo.getListSize() );
                log.info("info getBlockingQueue {} ,getListSize {},currentTimeMillis {}, getTriggerTime {}",linkedListDemo.getBlockingQueue().size(),linkedListDemo.getListSize(),System.currentTimeMillis(),linkedListDemo.getTriggerTime());
                log.info("the queue size is {}",linkedListDemo.blockingQueue.size());
                log.info("pretend post data to big data  restTime reset{}", resetTime);
                linkedListDemo.getBlockingQueue().clear();
                log.info("queue size empty success");
                log.info("the queue size after is {}",linkedListDemo.blockingQueue.size());
            }
        }

    }

    @PostConstruct
    public void runTask(){
        log.info("task submitted");
        testThreadPool.submit(this);
/*        testThreadPool.submit(() -> {
            while (true){
               // log.info("the  size{}",linkedListDemo.getBlockingQueue().size());
                //log.info("the  size{}",linkedListDemo.getListSize());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }
}
