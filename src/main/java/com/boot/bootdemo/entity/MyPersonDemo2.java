package com.boot.bootdemo.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * author: yuzq
 * create: 2021-04-09 16:49
 **/
@Data
public class MyPersonDemo2 {

    @NotEmpty
    private String age;

    @NotNull
    private Integer meter;
}
