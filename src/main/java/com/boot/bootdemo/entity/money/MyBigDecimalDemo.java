package com.boot.bootdemo.entity.money;

import com.boot.bootdemo.config.serilize.MyBigDecimalSerializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MyBigDecimalDemo {


    private String name;

    @JsonSerialize(using = MyBigDecimalSerializable.class,nullsUsing = MyBigDecimalSerializable.class)
    private BigDecimal money;

    private Integer age;
}
