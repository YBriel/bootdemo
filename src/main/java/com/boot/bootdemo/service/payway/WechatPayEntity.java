package com.boot.bootdemo.service.payway;

import lombok.Data;

/**
 * author: yuzq
 * create: 2021-06-22 18:06
 **/
@Data
public class WechatPayEntity extends BasePay{

    private String name="wechat";

    private String openId;
}
