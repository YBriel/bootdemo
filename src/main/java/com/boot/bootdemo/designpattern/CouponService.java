package com.boot.bootdemo.designpattern;

/**
 * author: yuzq
 * create: 2020-04-17 11:08
 **/
public interface CouponService {

    String allocateCoupon(String phone,String batchNum);

    String allocateCouponDemo(CouponCheck couponCheck);
}
