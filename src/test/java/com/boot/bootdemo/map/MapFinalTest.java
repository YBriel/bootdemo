package com.boot.bootdemo.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * final map 测试
 * author: yuzq
 * create: 2021-03-02 20:58
 **/
public class MapFinalTest {

    private static final Map<Integer,Integer> map=new HashMap<Integer,Integer>(){{
       put(1,2);
       put(11,2);
       put(12,2);

    }};

    private static final Map<Integer,Integer> mapFinal;


    static {
        Map<Integer,Integer> integerIntegerMap=new HashMap<>();
        integerIntegerMap.put(1,2);
        mapFinal=Collections.unmodifiableMap(integerIntegerMap);

    }


    public static void main(String[] args) {
        MapFinalTest.map.put(4,5);
        MapFinalTest.map.remove(1);

        mapFinal.put(1,23);

        System.out.println(map.size());
    }
}
