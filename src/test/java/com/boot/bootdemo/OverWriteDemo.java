package com.boot.bootdemo;

/**
 * author: yuzq
 * create: 2020-07-21 08:56
 **/
public class OverWriteDemo {

    public String test(int a ,int b){
        System.out.println(a+""+b);
        return "";
    }

    public int test(int a ,int b,int c){
        System.out.println(a+""+b);
        return a+b;
    }

    public static void main(String[] args) {
        OverWriteDemo overWriteDemo=new OverWriteDemo();

    }
}
