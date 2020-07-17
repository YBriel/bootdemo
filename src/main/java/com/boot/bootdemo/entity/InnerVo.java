package com.boot.bootdemo.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * author: yuzq
 * create: 2020-07-08 10:12
 **/
@Data
public class InnerVo {
/*    private String type;
    private String source;*/
    private String name;
    private int age;

    public static void main(String[] args) {
/*        InnerVo innerVo=new InnerVo();
        innerVo.setAge(11);
        innerVo.setName("tom");
        innerVo.setSource("0");
        innerVo.setType("orderCreate");
        System.out.println(JSONObject.toJSONString(innerVo));*/
    }
}
