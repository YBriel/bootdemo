package com.boot.bootdemo.designpattern.singleton;

/**
 * author: yuzq
 * create: 2020-08-13 20:01
 **/
public class DCLMode {

    public static DCLMode dclMode=null;

    public static DCLMode getInstance(){
        if(dclMode==null){
            synchronized (DCLMode.class){
                if(dclMode==null){
                    dclMode=new DCLMode();
                }
            }
        }
        return dclMode;
    }
}
