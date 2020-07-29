package com.boot.bootdemo.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;

/**
 * author: yuzq
 * create: 2020-07-29 18:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyCallableTest implements Callable<String> {

    private String name;

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "哈哈哈哈";
    }
}
