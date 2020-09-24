package com.boot.bootdemo.designpattern.filter;

import java.util.Iterator;
import java.util.List;

/**
 * author: yuzq
 * create: 2020-09-24 17:33
 **/
public class MyList1 extends AbsMyList {

    @Override
    public List<String> filter() {
        System.out.println("开始过滤aaa");
        System.out.println(list.size());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("aaa")){
                iterator.remove();
            }
        }
        System.out.println("结束过滤aaa");
        System.out.println(list.size());
        return list;
    }
}
