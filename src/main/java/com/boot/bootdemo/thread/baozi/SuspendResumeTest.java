package com.boot.bootdemo.thread.baozi;

/**
 * suspend挂起目标线程   resume恢复线程执行
 * author: yuzq
 * create: 2021-01-21 16:50
 **/
public class SuspendResumeTest {


    public static Object baozi=null;

    public void suspendTest(){
        String name = Thread.currentThread().getName();
        Thread thread = Thread.currentThread();
        System.out.println("开始--"+name);
        Thread consumer=new Thread(()->{
            if(baozi==null){
                System.out.println("没有包子，开始等包子");
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().suspend();
                System.out.println(Thread.currentThread().getName());
            }
            System.out.println("2.买到包子。回家");
        });
        consumer.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("有包子了，通知消费者");
        consumer.resume();

    }

    public static void main(String[] args) {
        SuspendResumeTest suspendResumeTest=new SuspendResumeTest();
        suspendResumeTest.suspendTest();
    }
}
