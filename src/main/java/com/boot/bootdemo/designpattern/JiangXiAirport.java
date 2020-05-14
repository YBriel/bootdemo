package com.boot.bootdemo.designpattern;

import java.util.Map;

/**
 * author: yuzq
 * create: 2020-04-17 11:16
 **/
public class JiangXiAirport extends CouponCheck {

    @Override
    public void initParam(String phone, String batchNum) {
       this.phone=phone;
       this.batchNum=batchNum;
    }

    public String allocateJxAirport(){
        PostJXAirPort airPort=new PostJXAirPort();
        String s = airPort.postJxAirPort("111");
        if(s.equals("success")){
            this.initParam("111","222");
            return this.invokeAllocate();
        }
        return s;
    }

    public static void main(String[] args) {
        JiangXiAirport jiangXiAirport=new JiangXiAirport();
        String s = jiangXiAirport.allocateJxAirport();
        System.out.println(s);
    }
}
