package com.boot.bootdemo.service.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-10-17 15:30
 **/
@Component
public class PearDemo {

    private static Apple apple;

    @Autowired
    public void setApple(Apple a){
        System.out.println("aaaaa");
        apple=a;
    }
}
