package com.boot.bootdemo.service.payway;

import java.util.Map;

/**
 * author: yuzq
 * create: 2021-06-22 18:07
 **/
public class AliPayServiceImpl implements PayWayService {


    @Override
    public <T extends BasePay> Map<String, Object> genMap(T t) {
        AliPay t1 = (AliPay) t;
        Map<String, Object> map = genMap();
        map.put("money",t1.getMoney());
        map.put("payName",t1.getName());
        return map;
    }

}
