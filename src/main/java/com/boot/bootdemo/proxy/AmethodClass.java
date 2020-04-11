package com.boot.bootdemo.proxy;

public class AmethodClass {
    public void a() {
        System.out.println("====aaaaaaa===");
    }

    public void b() {
        System.out.println("====bbbbb===");
    }

    public static void before() {
        System.out.println("====before===");
    }

    public static void post() {
        System.out.println("====post===");
    }

}