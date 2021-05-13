package com.boot.bootdemo.controller;

import com.boot.bootdemo.exception.AuthException;
import com.boot.bootdemo.service.TaskService;
import com.boot.bootdemo.service.TaskServiceCopy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2021-01-26 19:57
 **/
@RestController
@RequestMapping("retry")
@Slf4j
public class RetryController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("test")
    public void test(Integer a){
        taskService.test(a);
    }
}
