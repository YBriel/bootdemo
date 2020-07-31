package com.boot.bootdemo.entity;

/**
 * author: yuzq
 * create: 2020-07-31 18:58
 **/
public class StaticTest {

    private String name;

    static {
        System.out.println("这是static...");
    }

    {
        System.out.println("{ }...");
    }

    public StaticTest() {
        System.out.println("无参构造");
    }

    public StaticTest(String name) {
        this.name = name;
        System.out.println("有参构造");
    }

    public static void main(String[] args) {
        StaticTest staticTest=new StaticTest();

    }
}
