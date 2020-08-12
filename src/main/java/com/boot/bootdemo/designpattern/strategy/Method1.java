package com.boot.bootdemo.designpattern.strategy;

/**
 * author: yuzq
 * create: 2020-08-06 10:22
 **/
public class Method1 implements StrategyHandler {

/*    private static Method1 m;
    static {
        m=new Method1();
    }

    static {
        MyFactory.register("method1",m);
    }*/

    @Override
    public void doSomething(String name) {
        System.out.println("这是..."+name);
    }

}
