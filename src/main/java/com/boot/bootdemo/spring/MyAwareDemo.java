package com.boot.bootdemo.spring;

import com.boot.bootdemo.entity.Son;
import  static java.lang.Integer.*;
import  static java.lang.System.out;
import com.boot.bootdemo.entity.Student;
import jodd.util.MathUtil;

/**
 * description:
 * author: yuzq
 * date: 2020/5/28 17:49
 */
public class MyAwareDemo {
    static Son student = new Son();
    private static  Son test() throws InterruptedException {
        System.out.println("这是..."+student);
        return student;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    MyAwareDemo.test().setAge(MathUtil.randomInt(1,22));
                    System.out.println(MyAwareDemo.test());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"1").start();
        }
    }
}
