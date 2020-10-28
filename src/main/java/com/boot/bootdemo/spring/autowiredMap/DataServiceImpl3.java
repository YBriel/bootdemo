package com.boot.bootdemo.spring.autowiredMap;

import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-10-28 09:43
 **/
@Component("DataServiceImpl3")
public class DataServiceImpl3 implements DataServiceDemo {
    @Override
    public void process() {
        System.out.println("DataServiceImpl3...");
    }
}
