package com.boot.bootdemo.proxy;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/25   8:25
 */
public class CglibDemo {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getA(){
        return 100;
    }

    public String getB(){
        return "你好";
    }
}
