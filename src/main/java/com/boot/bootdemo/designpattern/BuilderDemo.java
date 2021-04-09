package com.boot.bootdemo.designpattern;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * author: yuzq
 * create: 2021-04-08 16:29
 **/
@Slf4j
public class BuilderDemo {

    private List<String> list;

    public List<String> buildAge(){
        list.removeIf(o->o.equals("1"));
        for (String s : list) {
            if(s.equals("1")){
                log.info("过滤1");

            }
        }
        return list;
    }



}
