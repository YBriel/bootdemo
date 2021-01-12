package com.boot.bootdemo.exception;

/**
 * author: yuzq
 * create: 2021-01-12 09:51
 **/
public class MyTimeOutException extends RuntimeException {

    public MyTimeOutException() {
        super();
    }

    public MyTimeOutException(String message) {
        super("执行超时了");
    }
}
