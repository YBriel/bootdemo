package com.boot.bootdemo.util;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: yuzq
 * create: 2021-01-28 15:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TmcBack {

    private String code;
    private String desc;
    private JSONObject data;

}
