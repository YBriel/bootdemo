package com.boot.bootdemo.entity.privateConstruct;

import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-04-01 13:43
 **/

public class YunRequest {

    private String service;
    private String method;
    private final Map<String, Object> param;

    public YunRequest(String service, String method) {
        this.service = service;
        this.method = method;
        this.param = new LinkedHashMap();
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void put(String key, Object value) {
        this.param.put(key, value);
    }

    public Object get(String key) {
        return this.param.get(key);
    }

    public Map<String, Object> getParam() {
        return this.param;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
