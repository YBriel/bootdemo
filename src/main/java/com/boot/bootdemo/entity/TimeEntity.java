package com.boot.bootdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * author: yuzq
 * create: 2021-01-29 17:27
 **/
public class TimeEntity {

    @JsonFormat(pattern = "yyyy-MM-dd") //后端返回前端
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //前端返回后端
    private Date time;
}
