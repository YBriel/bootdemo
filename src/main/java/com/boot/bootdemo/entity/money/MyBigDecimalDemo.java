package com.boot.bootdemo.entity.money;

import com.alibaba.fastjson.JSONObject;
import com.boot.bootdemo.config.serilize.MyBigDecimalSerializable;
import com.boot.bootdemo.config.serilize.MyIntegerSerializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import netscape.javascript.JSObject;

import java.math.BigDecimal;

@Data
public class MyBigDecimalDemo {


    private String name;

    @JsonSerialize(using = MyBigDecimalSerializable.class,nullsUsing = MyBigDecimalSerializable.class)
    private BigDecimal money;

    @JsonSerialize(using = MyIntegerSerializable.class,nullsUsing = MyIntegerSerializable.class)
    private Integer age;

    public static void main(String[] args) {
        MyBigDecimalDemo decimalDemo=new MyBigDecimalDemo();
        decimalDemo.setName("tom");
        decimalDemo.setAge(12);
        decimalDemo.setMoney(BigDecimal.TEN);

        System.out.println(JSONObject.toJSONString(decimalDemo));
    }
}
