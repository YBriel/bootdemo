package com.boot.bootdemo.designpattern;

/**
 * author: yuzq
 * create: 2020-04-17 11:09
 **/
public class CouponServiceImpl implements CouponService   {

    @Override
    public String allocateCoupon(String phone, String batchNum) {
        System.out.println("调用了分券的方法");
        // TODO: 2020/4/17 调用分优惠券方法
        if(phone.equals("111") && batchNum.equals("222")){
            return "success";
        }
        return "fail";
    }

    @Override
    public String allocateCouponDemo(CouponCheck couponCheck) {
        System.out.println("调用了2分券的方法");
        // TODO: 2020/4/17 调用分优惠券方法
        if(couponCheck.getPhone().equals("111") && couponCheck.getBatchNum().equals("222")){
            return "success";
        }
        return "fail";
    }
}
