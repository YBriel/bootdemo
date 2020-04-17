package com.boot.bootdemo.coupon;

import org.springframework.stereotype.Service;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/17   22:36
 */
@Service
public class NormalStategy implements MyStrategy {
    @Override
    public double calPrice(double money) {
        return money*0.9;
    }
}
