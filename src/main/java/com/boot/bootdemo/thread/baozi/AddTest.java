package com.boot.bootdemo.thread.baozi;

/**
 * author: yuzq
 * create: 2021-01-22 14:58
 **/
public class AddTest {


    private static Integer a=0;
    private Integer b=100;

    private int c=0;

    private Integer test1(){
        a=a+1;
        return a;
    }

    private Integer test2(){
        a++;

        return a;
    }

    public void test32(){
        while (b>0){
            b--;
            ++c;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddTest addTest=new AddTest();
        System.out.println("开始--->"+addTest.a);
        Thread thread=new Thread(()->{
            addTest.test32();
 /*           for (int i = 0; i < 100; i++) {

                addTest.test1();
            }*/
        },"aaa");
        System.out.println("开始1--->"+addTest.a);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1=new Thread(()->{
            addTest.test32();
      /*      for (int i = 0; i < 100; i++) {
                addTest.test2();
            }*/
        },"aaa");

        thread.start();
        thread1.start();
//        thread.join();
//        thread1.join();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束--->"+addTest.c);
    }
}
