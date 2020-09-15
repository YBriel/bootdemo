package com.boot.bootdemo.thread.forkjoin;

import java.util.concurrent.*;

/**
 * author: yuzq
 * create: 2020-09-10 11:21
 **/
public class ForkJoinDemo1  {


    public static Integer get(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public  static Integer get1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 3;
    }

    public  static Integer get2(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> submit = executorService.submit(ForkJoinDemo1::get);
        Future<Integer> submit2 = executorService.submit(ForkJoinDemo1::get1);
        Future<Integer> submit3 = executorService.submit(ForkJoinDemo1::get2);
        Integer a=0;
        Integer b=0;
        Integer c=0;
        boolean flag=true;
        while (!submit.isDone() && !submit2.isDone() && !submit3.isDone()){
            flag=false;
        }
        if(!flag){
            try {
                a=submit.get();
                b=submit2.get();
                c=submit3.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(a+b+c);
    }

}
