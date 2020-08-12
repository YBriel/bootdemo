package com.boot.bootdemo.designpattern.strategy;

/**
 * author: yuzq
 * create: 2020-08-06 10:25
 **/
public class TestMain {

    public static void main(String[] args) {
        String name = "method1";
        Method1 a=new Method1();
        MyFactory.register("method1",a);
        StrategyHandler strategy = MyFactory.getInvokeStrategy(name);
        strategy.doSomething(name);
    }
}
