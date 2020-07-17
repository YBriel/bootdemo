package com.boot.bootdemo.entity;

import lombok.Data;

/**
 * author: yuzq
 * create: 2020-07-08 10:12
 **/
@Data
public class OuterVo {

    private String type;
    private String source;
    private InnerVo innerVo;
}
