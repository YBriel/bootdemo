package com.boot.bootdemo.config;

import com.boot.bootdemo.spring.autowiredMap.DataServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-05-10 17:21
 **/
@Component
public class MyMapDemo {


    @Autowired
    @Qualifier(value = "DataServiceImpl1")
    private DataServiceDemo dataServiceImpl1;

    @Autowired
    @Qualifier(value = "DataServiceImpl2")
    private DataServiceDemo dataServiceImpl2;


    @Autowired
    @Qualifier(value = "DataServiceImpl3")
    private DataServiceDemo dataServiceImpl3;

    @Bean
    public Map<String, DataServiceDemo> myMap(){
        Map<String,DataServiceDemo> map=new HashMap<>();
        map.put("dataServiceImpl1",dataServiceImpl1);
        map.put("dataServiceImpl2",dataServiceImpl2);
        map.put("dataServiceImpl3",dataServiceImpl3);
        return map;
    }
}
