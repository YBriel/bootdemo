package com.boot.bootdemo.designpattern.strategy.spring;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * author: yuzq
 * create: 2021-03-06 10:39
 **/
@Service
public class SaveMTOrder implements ISaveOrder {


    @Resource
    private RestTemplate httpsRest;

    @Override
    public String saveOrder() {
        return "mt订单";
    }
}
