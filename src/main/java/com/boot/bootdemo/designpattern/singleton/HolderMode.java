package com.boot.bootdemo.designpattern.singleton;

/**
 * author: yuzq
 * create: 2020-08-13 20:06
 *
 * 声明类的时候，成员变量中不声明实例变量，而放到内部静态类中，
 *  //懒加载
 *     //synchronized
 *     //<init>
 **/
public class HolderMode {

    private static class HolderInner{
        private static HolderMode holderMode=new HolderMode();
    }

    public HolderMode holderMode(){
        return HolderInner.holderMode;
    }
}
