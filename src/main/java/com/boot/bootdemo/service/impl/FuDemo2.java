package com.boot.bootdemo.service.impl;

import com.boot.bootdemo.service.FuDemo1Service;
import com.boot.bootdemo.service.FuDemo2Service;

/**
 * author: yuzq
 * create: 2020-07-13 17:34
 **/
public class FuDemo2 implements FuDemo1Service {

    public static void main(String[] args) {
        String src = "[南京市玄武区北京东路徐州市鼓楼区戏马台]";
        //src = src.replaceAll("(?:江苏省|玄武区|鼓楼区)", "");
        src = src.replaceAll("[]\\[]", "");
        System.out.println(src);
    }
    @Override
    public void saySomething() {

    }
}
