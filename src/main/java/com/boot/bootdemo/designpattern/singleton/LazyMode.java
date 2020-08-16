package com.boot.bootdemo.designpattern.singleton;

/**
 * author: yuzq
 * create: 2020-08-13 19:53
 *
 * 线程安全：不能保证实例对象的唯一性
 **/
public class LazyMode {

    public static LazyMode lazyMode=null;

    public static LazyMode getInstance(){
        if(lazyMode==null){
            lazyMode=new LazyMode();
        }
        return lazyMode;
    }
}
