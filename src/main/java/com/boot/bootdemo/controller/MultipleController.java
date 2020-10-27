package com.boot.bootdemo.controller;

import com.boot.bootdemo.service.MultipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2020-10-27 17:56
 **/
@RestController
public class MultipleController {

    @Qualifier("multipleServiceImpl1")
    @Autowired
    private MultipleService multipleService;


    @RequestMapping("say")
    public void say(){
        multipleService.saySomething();
    }
}
