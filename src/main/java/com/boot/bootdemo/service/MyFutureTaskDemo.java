package com.boot.bootdemo.service;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * author: yuzq
 * create: 2020-07-29 18:31
 **/
public class MyFutureTaskDemo extends FutureTask<String> {
    public MyFutureTaskDemo(Callable<String> callable) {
        super(callable);
    }

    public MyFutureTaskDemo(Runnable runnable, String result) {
        super(runnable, result);
    }
}
