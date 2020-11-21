package com.boot.bootdemo.thread.pool;

/**
 * author: yuzq
 * create: 2020-11-21 15:36
 **/
public class OuterMain {



    public static void main(String[] args) {

        OuterTest test=new OuterTest();
        String name = test.getName();
        OuterTest.InnerTest innerTest = test.new InnerTest();
        System.out.println(test.getName());
        System.out.println(innerTest.getName());

    }
}
