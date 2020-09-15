package com.boot.bootdemo.thread.demo;

/**
 * author: yuzq
 * create: 2020-09-15 11:15
 * 新增一个线程调用新增的一个普通方法
 * 新增的方法没有被synchronized修饰，不是同步方法，不受锁的影响，所以不需要等待。其他线程共用了一把锁，所以还需要等待
 **/
public class Demo5 {
    public static void main(String[] args) {
        Number5 number = new Number5();

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getThree();
            }
        }).start();
    }
}

class Number5 {
    public synchronized void getOne() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree() {
        System.out.println("three");
    }
}

