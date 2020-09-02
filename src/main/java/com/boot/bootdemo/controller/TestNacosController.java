package com.boot.bootdemo.controller;

import com.boot.bootdemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * author: yuzq
 * create: 2020-08-31 10:39
 **/
@RestController
public class TestNacosController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("testNacos")
    public String test(){
        return memberService.test();
    }

    @RequestMapping("test111h")
    public String test1(){
        return "哈哈哈哈nacos";
    }

    @GetMapping(value = "/ttt")
    public String paymentInfo()
    {
        return restTemplate.getForObject("http://memberService",String.class);
    }
}
