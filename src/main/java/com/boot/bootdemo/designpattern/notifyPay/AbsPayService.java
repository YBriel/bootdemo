package com.boot.bootdemo.designpattern.notifyPay;

/**
 * author: yuzq
 * create: 2021-04-21 10:41
 **/
public abstract class AbsPayService<T> {


    protected void saveOrderPrice(){
        System.out.println("支付完成调用插入表操作");
    }




}
