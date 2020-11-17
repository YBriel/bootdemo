package com.boot.bootdemo;

/**
 * author: yuzq
 * create: 2020-10-28 22:22
 **/
public class TestLoop {

    public static void main(String[] args) {
        int j=0;
        for (int i = 0; i < 100; i++) {

            j=j++;
        }
        System.out.println(j);
    }
}
