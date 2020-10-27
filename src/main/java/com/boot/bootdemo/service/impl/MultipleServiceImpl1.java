package com.boot.bootdemo.service.impl;

import com.boot.bootdemo.service.MultipleService;
import org.springframework.stereotype.Service;

/**
 * author: yuzq
 * create: 2020-10-27 17:55
 **/
@Service
public class MultipleServiceImpl1 implements MultipleService {
    @Override
    public void saySomething() {
        System.out.println("MultipleServiceImpl1...");
    }
}
