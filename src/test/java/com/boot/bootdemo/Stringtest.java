package com.boot.bootdemo;

/**
 * author: yuzq
 * create: 2020-10-30 11:26
 **/
public class Stringtest {
    public static void main(String[] args) {
        while (true){
            System.out.println("林浩然是大帅哥");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
