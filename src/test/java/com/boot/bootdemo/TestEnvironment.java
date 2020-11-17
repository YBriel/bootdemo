package com.boot.bootdemo;

import com.boot.bootdemo.util.UtilProperty;

import java.util.Map;
import java.util.Properties;

/**
 * author: yuzq
 * create: 2020-11-17 15:06
 **/
public class TestEnvironment {

    public static void main(String[] args) {
       /* Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();
        String property = System.getProperty("driver");
        System.out.println(property);*/
        String driver = UtilProperty.getProperties("name");
        String driver1 = UtilProperty.getProperties("my.name");

        System.out.println(driver);
        System.out.println(driver1);
    }
}
