package com.boot.bootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.bootdemo.entity.Student;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   20:00
 */
public interface StudentService extends IService<Student> {

    Student queryStu(String name,Integer age);

    int updStuById(Integer id,String name);

    String testThreadPool();


    String futureTask() throws InterruptedException , ExecutionException, TimeoutException;

    String futureTaskDemo();

    String futureTaskDemo(long time,long sleepTime);
}
