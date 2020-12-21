package com.boot.bootdemo;

/**
 * author: yuzq
 * create: 2020-12-18 17:07
 **/
public class TestEnv {

    public static void main(String[] args) {
        String myname = System.getProperty("myname");
        System.out.println(myname);
    }
}
