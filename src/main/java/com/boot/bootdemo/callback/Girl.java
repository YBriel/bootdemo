package com.boot.bootdemo.callback;

/**
 * author: yuzq
 * create: 2020-06-05 18:36
 **/
public class Girl {

    public void washFace(String food,EatRice rice){
        System.out.println("girl wash face...");
        rice.eat(food);
    }

}
