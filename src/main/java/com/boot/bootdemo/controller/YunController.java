package com.boot.bootdemo.controller;

import com.boot.bootdemo.entity.privateConstruct.YunClient;
import com.boot.bootdemo.entity.privateConstruct.YunConfig;
import com.boot.bootdemo.entity.privateConstruct.YunRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2021-04-01 16:19
 **/
@RestController
@RequestMapping("yun")
public class YunController {


    @RequestMapping("test")
    public void test(){
        YunRequest request2=new YunRequest("hello","say");
        YunConfig config1=new YunConfig();
        YunClient.configure(config1);
        String request3 = YunClient.request(request2);
        System.out.println(request3);
    }


    @RequestMapping("test1")
    public void test1(){
        YunRequest request2=new YunRequest("hello","say");
        String request3 = YunClient.request(request2);
        System.out.println(request3);
    }
}
