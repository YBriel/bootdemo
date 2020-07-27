package com.boot.bootdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.bootdemo.aspect.Dict;
import com.boot.bootdemo.aspect.LogA;
import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.mapper.StudentMapper;
import com.boot.bootdemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   20:01
 */
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;




    @Resource
    private ThreadPoolTaskExecutor testThreadPool;


    @Override

    public Student queryStu(String name,Integer age) {
        ThreadPoolExecutor threadPoolExecutor = testThreadPool.getThreadPoolExecutor();
        int activeCount = threadPoolExecutor.getActiveCount();
        int corePoolSize = threadPoolExecutor.getCorePoolSize();
        int poolSize = threadPoolExecutor.getPoolSize();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        int largestPoolSize = threadPoolExecutor.getLargestPoolSize();
        int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
        int size = threadPoolExecutor.getQueue().size();
        long taskCount = threadPoolExecutor.getTaskCount();
        long keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS);
        ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
        log.info("activeCount {} corePoolSize {} poolSize {} completedTaskCount {} largestPoolSize {} maximumPoolSize{} queueSize {} taskCount {} keepAliveTime {}",
                activeCount,corePoolSize,poolSize,completedTaskCount,largestPoolSize,maximumPoolSize,size,taskCount,keepAliveTime);
        Student student=new Student();
        student.setAge(age);
        student.setName(name);
        System.out.println("初始前"+ JSON.toJSONString(student));
        return student;
    }

    public int updStuById(Integer id,String name){
        Student student = studentMapper.selectById(id);
        student.setName(name);
        int i = studentMapper.updateById(student);
        System.out.println(i);
        return i;
    }

    @Override
    @Async("testThreadPool")
    public String testThreadPool() {
        //log.info("执行开始{}",Thread.currentThread().getName());
        ThreadPoolExecutor threadPoolExecutor = testThreadPool.getThreadPoolExecutor();
       // log.info("active {} core{} max {} keep{} pool {}",testThreadPool.getActiveCount(),testThreadPool.getCorePoolSize(),testThreadPool.getMaxPoolSize(),testThreadPool.getKeepAliveSeconds(),testThreadPool.getPoolSize());
        try {
            int activeCount = threadPoolExecutor.getActiveCount();
            int corePoolSize = threadPoolExecutor.getCorePoolSize();
            int poolSize = threadPoolExecutor.getPoolSize();
            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
            int largestPoolSize = threadPoolExecutor.getLargestPoolSize();
            int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
            int size = threadPoolExecutor.getQueue().size();
            long taskCount = threadPoolExecutor.getTaskCount();
            long keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS);
            ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
            log.info("activeCount {} corePoolSize {} poolSize {} completedTaskCount {} largestPoolSize {} maximumPoolSize{} queueSize {} taskCount {} keepAliveTime {}",
                    activeCount,corePoolSize,poolSize,completedTaskCount,largestPoolSize,maximumPoolSize,size,taskCount,keepAliveTime);
            //log.info("开始休眠{}",Thread.currentThread().getName());
            Thread.sleep(2000);
            //log.info("休眠结束{}",Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "执行成功";
    }


    public String futureTask() throws InterruptedException, ExecutionException, TimeoutException {
        FutureTask<String> stringFutureTask=new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "哈哈哈哈哈";
            }
        });
        return stringFutureTask.get(1000,TimeUnit.MILLISECONDS);
    }

    public String futureTaskDemo() {
        FutureTask<String> stringFutureTask=new FutureTask<>(() -> "哈哈哈哈哈");
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
                return "哈哈哈";
            }
        });
        System.out.println("哈哈哈哈哈哈哈");
        try {
            String s = stringFutureTask.get();
            System.out.println("---------------------"+s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return stringFutureTask.get(time,TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.info("time {}执行有问题了",time);
            e.printStackTrace();
        }
        return null;
    }

}
