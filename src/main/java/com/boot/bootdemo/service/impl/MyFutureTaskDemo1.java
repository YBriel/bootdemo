package com.boot.bootdemo.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/7/27   21:03
 */
public class MyFutureTaskDemo1 extends FutureTask<String> {

    public MyFutureTaskDemo1(Callable<String> callable) {

        super(callable);
    }
}
