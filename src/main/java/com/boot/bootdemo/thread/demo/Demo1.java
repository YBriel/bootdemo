package com.boot.bootdemo.thread.demo;

/**
 * author: yuzq
 * create: 2020-09-15 11:08
 * 两个线程调用同一个对象的两个同步方法
 * 被synchronized修饰的方法，锁的对象是方法的调用者。因为两个方法的调用者是同一个，所以两个方法用的是同一个锁，先调用方法的先执行
 **/
public class Demo1 {
    public static void main(String[] args) {
       Number number=new Number();

        new Thread(number::getOne).start();

        new Thread(number::getTwo).start();
    }
}

class Number {
    public synchronized void getOne() {
        System.out.println("one");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void getTwo() {
        System.out.println("two");
    }
}
