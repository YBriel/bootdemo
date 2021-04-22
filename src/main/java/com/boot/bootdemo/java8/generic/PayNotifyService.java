package com.boot.bootdemo.java8.generic;

import lombok.Data;

/**
 * author: yuzq
 * create: 2021-04-18 09:43
 **/
@Data
public class PayNotifyService implements TLNotifyService<PayNotify> {

    private String name;

    @Override
    public PayNotify gen(String content) {
        return null;
    }

    public static void main(String[] args) {
        TLNotifyService<PayNotify> service=new PayNotifyService();
        PayNotifyService service1 = (PayNotifyService) service;
        String name = service1.name;
    }
}
