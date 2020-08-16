package com.boot.bootdemo.designpattern.singleton;

/**
 * author: yuzq
 * create: 2020-08-13 19:50
 * 饿汉模式
 * 线程安全性：在加载的时候已经被实例化，所以只有这一次，线程安全的。JVM  ClassLoader
 *  懒加载：没有延迟加载，好长时间不使用，影响性能
 *  性能比较好
 * 不是懒加载
 **/
public class HungryMode {


    public static HungryMode hungryMode=new HungryMode();

    public static HungryMode getHungryMode(){
        return hungryMode;
    }
}
