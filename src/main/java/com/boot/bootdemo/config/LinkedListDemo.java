package com.boot.bootdemo.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * author: yuzq
 * create: 2020-07-30 09:19
 **/
@Data
@Slf4j
public class LinkedListDemo {

    public LinkedBlockingQueue<Long> blockingQueue = null;
    //ConcurrentLinkedQueue

    private Long triggerTime;

    private Integer listSize;

    public LinkedListDemo() {
    }


    public LinkedListDemo(Integer listSize){
        Assert.notNull(listSize,"list size couldn't be null or zero!");
        this.blockingQueue=new LinkedBlockingQueue<>(listSize);
        log.info("the queue size has been set as {}",listSize);
        log.info("parameter triggerTime has been set as a default value 60 seconds ");
        this.triggerTime=60000L;
        this.listSize=listSize;
    }
}
