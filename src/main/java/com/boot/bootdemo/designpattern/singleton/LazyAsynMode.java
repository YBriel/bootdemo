package com.boot.bootdemo.designpattern.singleton;

/**
 * author: yuzq
 * create: 2020-08-13 19:53
 *
 * 线程安全：但是不能退化到串行化 性能低
 *
 **/
public class LazyAsynMode {

    public static LazyAsynMode lazyMode=null;

    public synchronized static LazyAsynMode getInstance(){
        if(lazyMode==null){
            lazyMode=new LazyAsynMode();
        }
        return lazyMode;
    }
}
