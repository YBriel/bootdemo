package com.boot.bootdemo.controller;

import com.boot.bootdemo.entity.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2021-03-13 10:42
 **/
@RestController
@RequestMapping("tl")
public class InterceptorController {


    @RequestMapping("test")
    public String test(@RequestBody Student student){
        return student.getName();
    }



    @RequestMapping("test1")
    public String test1( Student student){
        return student.getName();
    }

    @RequestMapping("test2")
    public String test2(@RequestBody Student student){
        return student.getName();
    }
}
