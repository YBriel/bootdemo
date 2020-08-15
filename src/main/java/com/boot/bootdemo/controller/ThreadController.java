package com.boot.bootdemo.controller;

import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: yuzq
 * create: 2020-08-12 18:56
 **/
@RestController
@RequestMapping("thread")
@Slf4j
public class ThreadController {

    @Autowired
    private StudentService studentService;

    private static ExecutorService executorService=Executors.newSingleThreadExecutor();

    @RequestMapping("test")
    public void test(){
        log.info("开始执行executorService...");
        executorService.execute(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Student student = studentService.getById(1);
            int age = student.getAge();
            student.setAge(++age);
            studentService.updateById(student);
        });
        log.info("executorService.isTerminated()..{}",executorService.isTerminated());
        log.info("executorService.isShutdown()..{}",executorService.isShutdown());

    }
}
