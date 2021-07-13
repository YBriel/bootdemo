package com.boot.bootdemo.util;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * author: yuzq
 * create: 2021-07-12 15:02
 **/
public class MyIdWorker extends IdWorker {


    public MyIdWorker() {
        System.out.println("哈哈哈1");
        MyIdWorker.initSequence(1,2);
    }

}

