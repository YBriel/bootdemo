package com.boot.bootdemo.config;

import com.boot.bootdemo.value.Value;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-11-17 16:27
 **/
@Configuration
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
