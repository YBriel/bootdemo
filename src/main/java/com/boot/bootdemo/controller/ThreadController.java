package com.boot.bootdemo.controller;

import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.mapper.StudentMapper;
import com.boot.bootdemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
    @Autowired
    private StudentMapper studentMapper;


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

    @RequestMapping("test1")
    @Transactional
    public String test1(int i){
        log.info("请求进来了{}",new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Student stu = studentMapper.getStu(i);
        int age = stu.getAge();
        stu.setAge(age+1);
        int update = studentMapper.updateById(stu);
        return "success";
    }
}
