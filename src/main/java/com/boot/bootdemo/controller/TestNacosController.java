package com.boot.bootdemo.controller;

import com.boot.bootdemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2020-08-31 10:39
 **/
@RestController
public class TestNacosController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("testNacos")
    public String test(){
        return memberService.test();
    }
}
