package com.boot.bootdemo.entity;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/1   10:02
 */
public class Parent {

    private String name;
    private int age;

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Parent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
