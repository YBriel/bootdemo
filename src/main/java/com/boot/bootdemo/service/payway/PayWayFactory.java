package com.boot.bootdemo.service.payway;

import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-06-22 18:04
 **/
public class PayWayFactory {

    public static   Map<Integer,PayWayService> map=new HashMap<>();

    static {
        map.put(1,new WechatPayImpl());
        map.put(2,new AliPayServiceImpl());
    }

    public static PayWayService getPayWay(Integer code){
        return map.get(code);
    }


    public static void main(String[] args) {
        WechatPayEntity entity=new WechatPayEntity();
        entity.setName("wesaeji");
        entity.setOpenId("37213");
        entity.setMoney(123);
        PayWayService payWay = PayWayFactory.getPayWay(1);
        Map<String, Object> map = payWay.genMap(entity);
        System.out.println(map);
    }
}
