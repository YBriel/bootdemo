package com.boot.bootdemo.service;

/**
 * author: yuzq
 * create: 2021-06-10 16:16
 **/
public class MyAnonymousImpl implements AnonymousInterface {
    @Override
    public String test(String a, Integer b) {
        System.out.println(a);
        return a;
    }


    public static void main(String[] args) {

        new MyAnonymousImpl(){
            @Override
            public String test(String a, Integer b) {
                System.out.println("sdasds");
                return super.test(a, b);
            }
        }.test("2313",1);
    }
}
