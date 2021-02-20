package com.boot.bootdemo.util;

import java.util.*;

/**
 * 高效遍历map
 * list新写法
 *
 * author: yuzq
 * create: 2021-02-20 17:19
 **/
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>() {{
            put("aa", "bb");
        }};

        List<String> aa=new ArrayList<String>(){{
            add("aa");
        }};


        //效率高
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
        //效率低
        Iterator iter1 = map.keySet().iterator();
        while (iter1.hasNext()) {
            Object key = iter.next();
            Object val = map.get(key);
        }
    }

}
