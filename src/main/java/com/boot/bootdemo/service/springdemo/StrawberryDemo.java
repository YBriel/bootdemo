package com.boot.bootdemo.service.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-10-17 15:28
 **/
@Component
public class StrawberryDemo {

    @Autowired
    private Apple apple;

    public String getName(){
        String name = apple.getName();
        System.out.println(name);
        return name;
    }
}
