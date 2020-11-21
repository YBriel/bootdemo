package com.boot.bootdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-11-17 16:27
 **/
@Component
public class TestConfig {

    @Value("${my.name}")
    String name;

    private String age="323";


    public String nap(){
        return name;
    }

    public String ageGet(){
        return age;
    }


}
