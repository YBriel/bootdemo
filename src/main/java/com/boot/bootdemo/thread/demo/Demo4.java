package com.boot.bootdemo.thread.demo;

/**
 * author: yuzq
 * create: 2020-09-15 11:07
 * 被synchronized和static修饰的方法，锁的对象是类的class对象。因为两个同步方法都被static修饰了，即便用了两个不同的对象调用方法，两个方法用的还是同一个锁，后调用的方法需要等待先调用的方法。
 **/
public class Demo4 {
    public static void main(String[] args) {
        Number3 numberOne = new Number3();
        Number3 numberTwo = new Number3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                numberOne.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                numberTwo.getTwo();
            }
        }).start();
    }
}

class Number3 {
    public static synchronized void getOne() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }
}
