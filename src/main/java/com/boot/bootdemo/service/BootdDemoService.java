package com.boot.bootdemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: yuzq
 * create: 2020-09-03 09:07
 **/
@FeignClient("jeecg")
public interface BootdDemoService {

    @RequestMapping("/testNacos")
     String testNacos();
}
