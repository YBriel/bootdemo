package com.boot.bootdemo.thread.demo;

/**
 * author: yuzq
 * create: 2020-09-15 11:01
 *
 *
 * 被synchronized和static修饰的方法，锁的对象是类的class对象。仅仅被synchronized修饰的方法，锁的对象是方法的调用者。
 * 因为两个方法锁的对象不是同一个，所以两个方法用的不是同一个锁，后调用的方法不需要等待先调用的方法。
 **/
public class Demo2 {
    public static void main(String[] args) {
        Number1 number=new Number1();

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

class Number1 {
    public static synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public synchronized void getTwo() {
        System.out.println("two");
    }
}
