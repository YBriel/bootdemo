package com.boot.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.GeoEntry;
import org.redisson.api.RGeo;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * author: yuzq
 * create: 2020-08-27 14:30
 **/
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduledController {

    @Autowired
    private ScheduledThreadPoolExecutor myScheduleThreadPool;

    private static Map<Integer, Runnable> map=new ConcurrentHashMap<>();

    @Autowired
    RedissonClient redissonClient;

    @RequestMapping("test1")
    public String test1(Long time){
        RGeo<String> geo = redissonClient.getGeo("test1",StringCodec.INSTANCE);
        long l = System.currentTimeMillis();
        String s = "nantian" + l;
        geo.add(new GeoEntry(111.838936,28.741351,s));
        log.info("收到调度{}",new Date());
        ScheduledFuture<?> schedule = myScheduleThreadPool.schedule(() -> {
            geo.remove(s);

            log.info("执行删除redis任务了{}", new Date());
        }, time, TimeUnit.SECONDS);
        int activeCount = myScheduleThreadPool.getActiveCount();
        long completedTaskCount = myScheduleThreadPool.getCompletedTaskCount();
        BlockingQueue<Runnable> queue = myScheduleThreadPool.getQueue();
        int i = queue.remainingCapacity();
        BlockingQueue<Runnable> queue1 = myScheduleThreadPool.getQueue();
/*        for (Runnable runnable : queue1) {
            queue1.remove(runnable);
        }*/
        return "success";
    }




    @RequestMapping("getThreadPoolInfo")
    public Map<String,Object> getThreadPoolInfo(){
        Map<String,Object> map=new HashMap<>();
        long taskCount = myScheduleThreadPool.getTaskCount();
        int activeCount = myScheduleThreadPool.getActiveCount();
        BlockingQueue<Runnable> queue = myScheduleThreadPool.getQueue();
        int size = queue.size();
        int maximumPoolSize = myScheduleThreadPool.getMaximumPoolSize();
        int largestPoolSize = myScheduleThreadPool.getLargestPoolSize();
        int corePoolSize = myScheduleThreadPool.getCorePoolSize();
        long completedTaskCount = myScheduleThreadPool.getCompletedTaskCount();
        map.put("taskCount",taskCount);
        map.put("activeCount",activeCount);
        map.put("size",size);
        map.put("maximumPoolSize",maximumPoolSize);
        map.put("largestPoolSize",largestPoolSize);
        map.put("corePoolSize",corePoolSize);
        map.put("completedTaskCount",completedTaskCount);
        return map;
    }

    @RequestMapping("test2")
    public String test2(Long time,Integer id){

        if(map.get(id)!=null){
            return "添加任务失败";
        }
        Thread thread = new Thread(() -> System.out.println("hhh"));
        log.info("收到调度{}任务hashcode是{}",new Date(),thread.hashCode());


        RunnableScheduledFuture<?> schedule =(RunnableScheduledFuture<?>) myScheduleThreadPool.schedule(thread, time, TimeUnit.SECONDS);
        map.put(id,schedule);
        int activeCount = myScheduleThreadPool.getActiveCount();
        long completedTaskCount = myScheduleThreadPool.getCompletedTaskCount();
        BlockingQueue<Runnable> queue = myScheduleThreadPool.getQueue();
        int i = queue.remainingCapacity();
        BlockingQueue<Runnable> queue1 = myScheduleThreadPool.getQueue();
        return "success";
    }
    @RequestMapping("test3")
    public String test3(Integer id){

        Runnable runnable = map.get(id);
        //log.info("runnable   {}",runnable.hashCode());
        BlockingQueue<Runnable> queue = myScheduleThreadPool.getQueue();
        for (Runnable runnable1 : queue) {

            log.info("runnable1 {}",runnable1.hashCode());
        }

        boolean remove1 = myScheduleThreadPool.remove(runnable);
        boolean contains = queue.contains(runnable);
        log.info("map有{}当前队列有{}，包含目标线程{},移出{}",map.size(),queue.size(),contains,remove1);
        boolean remove = queue.remove(runnable);
        boolean contain1 = queue.contains(runnable);
        log.info("当前队列有{}，移出{}包含目标线程{}",queue.size(),remove,contain1);
        return "success";
    }
}
