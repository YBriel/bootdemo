package com.boot.bootdemo.entity;

import com.boot.bootdemo.aspect.LogA;
import lombok.Data;

/**
 * author: yuzq
 * create: 2020-04-13 16:17
 **/
@Data
public class LoginBean {
    private String name;

    private String testAge="90";

    @LogA
    private int age1;


    @Override
    public String toString() {
        return "Login{" +
                "name='" + name + '\'' +
                ", testAge='" + testAge + '\'' +
                ", age1=" + age1 +
                '}';
    }
}
