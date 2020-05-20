package com.boot.bootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author： yuzq
 * Description: RequestResponseBodyMethodProcessor
 * Date: 2020/5/20   22:44
 */
@RestController
public class MyStudentController {

    @RequestMapping("/student")
    public MyStudent student(){
        return new MyStudent();
    }
}
