package com.boot.bootdemo.util;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * author: yuzq
 * create: 2021-07-12 15:02
 **/
public class MyIdWorker2 extends IdWorker {


    public MyIdWorker2() {
        System.out.println("哈哈哈");
        MyIdWorker2.initSequence(113,5);
    }

    public static void main(String[] args) {
        DefaultIdentifierGenerator defaultIdentifierGenerator=new DefaultIdentifierGenerator(1,2);
        DefaultIdentifierGenerator defaultIdentifierGenerator2=new DefaultIdentifierGenerator(2,3);
        MyIdWorker.setIdentifierGenerator(defaultIdentifierGenerator);
        MyIdWorker2.setIdentifierGenerator(defaultIdentifierGenerator2);
        System.out.println(MyIdWorker.getId());
        System.out.println(MyIdWorker2.getId());
       // MyIdWorker.setIdentifierGenerator();
    }

}

