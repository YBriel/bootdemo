package com.boot.bootdemo.thread.demo;

/**
 * author: yuzq
 * create: 2020-09-15 11:04
 *
 * 被synchronized和static修饰的方法，锁的对象是类的class对象。因为两个同步方法都被static修饰了，所以两个方法用的是同一个锁，后调用的方法需要等待先调用的方法。
 **/
public class Demo3 {
    public static void main(String[] args) {
        Number2 number=new Number2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getTwo();
            }
        }).start();
    }
}

class Number2 {
    public static synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }
}
