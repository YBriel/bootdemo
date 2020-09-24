package com.boot.bootdemo.designpattern.filter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * author: yuzq
 * create: 2020-09-24 17:34
 **/
@Slf4j
public class AbsMyList  implements MyList{

    public static List<String> list=new ArrayList<>();

    public List<MyList> lists=new ArrayList<>();

    public void add(MyList absMyList){
        lists.add(absMyList);
        log.info("添加后size为{}",lists.size());
    }

     static{
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
    }

    public List<String> getRes(){
        for (MyList myList : lists) {
            myList.filter();
        }
        return list;
    }

    public static void main(String[] args) {
        AbsMyList absMyList=new AbsMyList();
        //absMyList.init();
        absMyList.add(new MyList1());
        absMyList.add(new MyList2());
        List<String> res = absMyList.getRes();
        System.out.println(res);
    }


    @Override
    public List<String> filter() {
        return null;
    }
}
