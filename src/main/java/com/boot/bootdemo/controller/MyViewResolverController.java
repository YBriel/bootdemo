package com.boot.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: yuzq
 * create: 2021-01-29 16:17
 **/
@Controller
@RequestMapping("view")
public class MyViewResolverController {


    @RequestMapping("hello")
    public String test(){
        return "myView:hello";
    }
}
