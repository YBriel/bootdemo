package com.boot.bootdemo.service.payway;

import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-06-22 18:04
 **/
public interface PayWayService {

    default Map<String,Object> genMap(){
        return new HashMap<>();
    }

    <T extends BasePay> Map<String,Object> genMap(T t);

}
