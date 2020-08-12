package com.boot.bootdemo.designpattern.strategy;

import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * author: yuzq
 * create: 2020-08-06 10:19
 **/
public class MyFactory {

/*    static {
        Method1 method1=new Method1();
    }*/

    private static HashMap<String,StrategyHandler> map=new HashMap<>();

    public static StrategyHandler getInvokeStrategy(String name) {
        return map.get(name);
    }

    public static void register(String name, StrategyHandler handler) {
        if (StringUtils.isEmpty(name) || null == handler) {
            return;
        }
        map.put(name, handler);
    }

}
