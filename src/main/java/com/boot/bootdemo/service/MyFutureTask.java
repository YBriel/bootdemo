package com.boot.bootdemo.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/7/27   20:42
 */
public interface MyFutureTask {


    String futureTask() throws InterruptedException , ExecutionException, TimeoutException;

    String futureTaskDemo();

    String futureTaskDemo(long time,long sleepTime);
}
