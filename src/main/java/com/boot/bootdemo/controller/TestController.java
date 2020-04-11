/*
package com.boot.bootdemo.controller;

import com.boot.bootdemo.apollo.TestJavaConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestJavaConfigBean testJavaConfigBean;

    @RequestMapping("get")
    public String get(){
        int batch = testJavaConfigBean.getBatch();
        int timeout = testJavaConfigBean.getTimeout();
        String mobile = testJavaConfigBean.getMobile();
        return "batch:"+batch+", timeout:"+timeout+"mobile"+mobile;
    }

}*/
