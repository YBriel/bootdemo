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
        System.out.println("父类有参构造");
    }

    public Parent() {
        System.out.println("父类无参构造");
    }

    public String getName() {
        System.out.println("父类getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("父类setName");
        this.name = name;
    }

    public int getAge() {
        System.out.println("父类getAge");
        return age;
    }

    public void setAge(int age) {
        System.out.println("父类setAge");
        this.age = age;
    }
}
