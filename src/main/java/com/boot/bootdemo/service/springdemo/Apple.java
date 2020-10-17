package com.boot.bootdemo.service.springdemo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-10-17 15:26
 **/
@Component
@Data
public class Apple {

    private String name;

    private Integer age;

    public Apple() {
        System.out.println("苹果无参构造...");
    }

    public Apple(String name, Integer age) {
        System.out.println("苹果有参构造...");
        this.name = name;
        this.age = age;
    }
}
