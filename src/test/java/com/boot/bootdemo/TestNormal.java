package com.boot.bootdemo;

/**
 * author: yuzq
 * create: 2020-04-18 10:11
 **/
public class TestNormal {

    public static void main(String[] args) {
        int i = 5;
        switch (i){
            case 5:
                System.out.println("是个5");
                break;
            case 10:
                System.out.println("是个10");
                break;
            case 4:
                System.out.println("是个4");
                break;
            default:
                System.out.println("默认值");
                break;
        }

    }
}
