package com.boot.bootdemo.designpattern.singleton;

/**
 * author: yuzq
 * create: 2020-08-13 20:01
 **/
public class DCLVolatileMode {

    public volatile static DCLVolatileMode dclMode=null;

    public static DCLVolatileMode getInstance(){
        if(dclMode==null){
            synchronized (DCLVolatileMode.class){
                if(dclMode==null){
                    dclMode=new DCLVolatileMode();
                }
            }
        }
        return dclMode;
    }
}
