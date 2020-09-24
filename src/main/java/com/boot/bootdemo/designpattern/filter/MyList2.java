package com.boot.bootdemo.designpattern.filter;

import java.util.Iterator;
import java.util.List;

/**
 * author: yuzq
 * create: 2020-09-24 17:33
 **/
public class MyList2 extends AbsMyList {

    @Override
    public List<String> filter() {
        System.out.println("开始过滤bbb");
        System.out.println(list.size());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("bbb")){
                iterator.remove();
            }
        }
        System.out.println("结束过滤bbb");
        System.out.println(list.size());
        return list;
    }
}
