package com.boot.bootdemo.controller;

import com.boot.bootdemo.aspect.LogPrint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2021-04-28 13:23
 **/
@RestController
@RequestMapping("log")
public class TestLogController {



    @LogPrint(title = "测试日志")
    @RequestMapping("test1")
    public String queryLog(String a,Integer b){

        return a;
    }
}
