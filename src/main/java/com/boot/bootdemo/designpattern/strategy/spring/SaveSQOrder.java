package com.boot.bootdemo.designpattern.strategy.spring;

import org.springframework.stereotype.Service;

/**
 * author: yuzq
 * create: 2021-03-06 10:39
 **/
@Service
public class SaveSQOrder implements ISaveOrder {

    @Override
    public String saveOrder() {
        return "sq订单";
    }
}
