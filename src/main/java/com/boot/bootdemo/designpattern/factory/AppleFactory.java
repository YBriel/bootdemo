package com.boot.bootdemo.designpattern.factory;

/**
 * author: yuzq
 * create: 2020-11-19 21:22
 **/
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Fruit("苹果");
    }
}
