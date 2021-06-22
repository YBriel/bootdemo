package com.boot.bootdemo.service.payway;

import java.util.Map;

/**
 * author: yuzq
 * create: 2021-06-22 18:09
 **/
public class WechatPayImpl implements PayWayService {


    @Override
    public <T extends BasePay> Map<String, Object> genMap(T t) {
        WechatPayEntity wechatPayEntity = (WechatPayEntity) t;
        Map<String, Object> map = genMap();
        map.put("money",wechatPayEntity.getMoney());
        map.put("name",wechatPayEntity.getName());
        map.put("openId",wechatPayEntity.getOpenId());
        return map;
    }
}
