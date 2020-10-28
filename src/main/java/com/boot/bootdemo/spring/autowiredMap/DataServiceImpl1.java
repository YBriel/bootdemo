package com.boot.bootdemo.spring.autowiredMap;

import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-10-28 09:42
 **/
@Component("DataServiceImpl1")
public class DataServiceImpl1 implements DataServiceDemo {

    @Override
    public void process() {
        System.out.println("DataServiceImpl1...");
    }
}
