package com.boot.bootdemo.login;

import com.boot.bootdemo.aspect.LogA;
import lombok.Data;

/**
 * author: yuzq
 * create: 2020-04-13 14:03
 **/
@Data
public class LoginEntity {

    @LogA()
    private String name;

    private int age;
}
