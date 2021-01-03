package com.boot.bootdemo.service.wrong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 循环依赖构造注入会有问题
 * 属性依赖属性不会有问题
 * author: yuzq
 * create: 2021-01-03 09:57
 **/
@Service
public class WrongService1 {

    @Autowired
    private WrongService2 wrongService2;
}
