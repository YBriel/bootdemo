package com.boot.bootdemo.map;

import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-01-20 09:48
 **/
public class TestMap {

    private Map<String,HelloService> map=new HashMap<>();


    public void addService(HelloService service){
        String name = service.getClass().getName();
        map.put(name,service);
        System.out.println(name);

        map.get(name).sayHello();
    }

    public static void main(String[] args) {
        TestMap testMap=new TestMap();
        testMap.addService(new HelloService());
    }
}
