package com.boot.bootdemo.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author: yuzq
 * create: 2020-08-12 14:49
 **/
public class TicketRob extends Thread {

    private static int index=1;

    private static final int MAX=500;

    private static List<Integer> list= Collections.synchronizedList(new ArrayList<>());

    static {
        list.add(0);
    }


    @Override
    public void run() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        while (index<=MAX){
            System.out.println(Thread.currentThread().getName()+"Max.."+(index++));
            Integer integer = list.get(0);
            integer++;
            list.add(0,integer);
        }
        System.out.println(list.get(0));
        readLock.unlock();
    }

    public static void main(String[] args) {
        TicketRob t=new TicketRob();
        TicketRob t2=new TicketRob();
        TicketRob t3=new TicketRob();
        TicketRob t4=new TicketRob();
        t.start();
        t2.start();
        t3.start();
        t4.start();

    }



}
