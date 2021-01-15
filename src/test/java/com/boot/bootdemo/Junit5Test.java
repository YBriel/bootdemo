package com.boot.bootdemo;

import org.junit.Test;

/**
 * author: yuzq
 * create: 2021-01-11 20:45
 **/

public class Junit5Test {

    @Test
    public void sayHello(){
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
    }
}
