package com.boot.bootdemo.designpattern.strategy;

/**
 * author: yuzq
 * create: 2020-08-06 10:22
 **/
public class Method2 implements StrategyHandler {

    {
        MyFactory.register("method2",this);
    }
    @Override
    public void doSomething(String name) {
        System.out.println("这是"+name);
    }

    /*@Override
    public void addToFactory() {
        MyFactory.register("method2",this);
    }*/
}
