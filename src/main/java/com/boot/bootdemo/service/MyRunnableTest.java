package com.boot.bootdemo.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * author: yuzq
 * create: 2020-07-29 18:01
 **/
@Data
@Slf4j
public class MyRunnableTest implements Runnable  {

    private String name;

    public MyRunnableTest() {
    }

    public MyRunnableTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        log.info("执行开始");
        log.info(name);
        log.info("开始休眠");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("结束休眠");

    }
}
