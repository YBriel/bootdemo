package com.boot.bootdemo.designpattern;

/**
 * author: yuzq
 * create: 2020-04-17 12:00
 **/
public class PostJXAirPort {

    public String postJxAirPort(String airNum){
        if(airNum.equals("111")){
            System.out.println("模拟调用江西航空成功");
            return "success";
        }
        System.out.println("模拟调用江西航空失败");
        return "fail";
    }
}
