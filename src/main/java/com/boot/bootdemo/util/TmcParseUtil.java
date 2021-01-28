package com.boot.bootdemo.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.boot.bootdemo.config.MyResult;

/**
 * author: yuzq
 * create: 2021-01-28 10:36
 **/
public class TmcParseUtil<T> {

    public static <T> MyResult<T> q(Class<T> c, String res) {
        MyResult<T> result = null;
        try {
            return JSONObject.parseObject(res, new TypeReference<MyResult<T>>() {
            });
        } catch (Exception e) {
            return null;
        }
    }
}
