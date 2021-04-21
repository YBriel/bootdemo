package com.boot.bootdemo.designpattern.notifyPay;

/**
 * author: yuzq
 * create: 2021-04-21 10:39
 **/
public interface NotifyService<T> {

    default boolean check() {
        return false;
    }

    T payNotify(String content);

}
