package com.boot.bootdemo.entity;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/1   10:03
 */
public class Son extends Parent {

    private String hobby;

    private String subject;

    public Son(String name, int age, String hobby) {
        super(name, age);
        this.hobby = hobby;
    }

    public static void main(String[] args) {


    }
}
