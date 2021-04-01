package com.boot.bootdemo.entity.privateConstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: yuzq
 * create: 2021-04-01 13:43
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YunConfig {

    private String name;
    private String age;
}
