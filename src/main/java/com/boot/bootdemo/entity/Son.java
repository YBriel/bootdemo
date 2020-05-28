package com.boot.bootdemo.entity;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/1   10:03
 */
public class Son extends Parent {

    private String hobby;

    private String subject;

    static {
        System.out.println("这是静态代码块");
    }
    {
        System.out.println("这不是静态代码块");
    }



    public Son() {
        System.out.println("这是空的构造函数");
    }


    public Son(String name, int age, String hobby) {
        super(name, age);
        this.hobby = hobby;
        System.out.println("这是有参的构造函数");
    }

    public static void main(String[] args) {

        Son s=new Son("1",22,"23");

    }
}
