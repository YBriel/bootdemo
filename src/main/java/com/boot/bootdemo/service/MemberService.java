package com.boot.bootdemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: yuzq
 * create: 2020-08-31 11:22
 **/
@FeignClient(value = "memberService",contextId = "memberService")
public interface MemberService {

    @GetMapping("world")
    String test();
}
