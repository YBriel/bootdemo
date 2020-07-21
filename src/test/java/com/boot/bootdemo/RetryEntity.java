package com.boot.bootdemo;

import lombok.Data;

/**
 * author: yuzq
 * create: 2020-07-18 11:40
 **/
@Data
public class RetryEntity {

    private Integer retryTimes;

    private String desc;
}
