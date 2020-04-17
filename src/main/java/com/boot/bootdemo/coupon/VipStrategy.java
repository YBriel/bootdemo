package com.boot.bootdemo.coupon;

import org.springframework.stereotype.Service;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/17   22:33
 */
@Service
public class VipStrategy implements MyStrategy {

    @Override
    public double calPrice(double money){
        return money*0.7;
    }
}
