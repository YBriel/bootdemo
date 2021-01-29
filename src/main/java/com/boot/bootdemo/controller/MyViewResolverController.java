package com.boot.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("hello1")
    public ModelAndView test1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello.html");
        return modelAndView;
    }

    @RequestMapping("hello2")
    public ModelAndView hello2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
