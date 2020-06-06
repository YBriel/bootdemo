package com.boot.bootdemo.callback;

/**
 * author: yuzq
 * create: 2020-06-05 18:36
 **/
public class PersonCall implements EatRice {


    @Override
    public void eat(String food) {
        System.out.println("和girl 一起去吃..."+food);
    }

    public void eatFood( ) {
        Girl girl=new Girl();
        girl.washFace("pig",this);

    }

    public static void main(String[] args) {
        PersonCall personCall=new PersonCall();
        personCall.eatFood();
    }
}
