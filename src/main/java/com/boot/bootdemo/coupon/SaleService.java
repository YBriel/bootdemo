package com.boot.bootdemo.coupon;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/17   22:39
 */
@Service
public class SaleService {

    Map<String,MyStrategy> myStrategyMap=new HashMap<>();


 /*  public SaleService saleService(@Autowired List<MyStrategy> strategyList){
       for (MyStrategy myStrategy : strategyList) {
           myStrategyMap.put(myStrategy.)
       }
   }*/

}
