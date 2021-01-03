package com.boot.bootdemo.service.wrong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: yuzq
 * create: 2021-01-03 09:57
 **/
@Service
public class WrongService2 {
    @Autowired
    private WrongService1 wrongService1;
}
