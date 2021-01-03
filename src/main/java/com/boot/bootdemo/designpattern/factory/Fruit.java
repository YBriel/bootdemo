package com.boot.bootdemo.designpattern.factory;

/**
 * author: yuzq
 * create: 2020-11-19 21:21
 **/
public class Fruit {

    private String name;


    public Fruit() {
    }

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void drawn(){

    }
}
