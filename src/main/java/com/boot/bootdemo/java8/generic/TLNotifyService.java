package com.boot.bootdemo.java8.generic;

/**
 * author: yuzq
 * create: 2021-04-18 09:41
 **/
public interface TLNotifyService<T> {


    T  gen(String content);
}
