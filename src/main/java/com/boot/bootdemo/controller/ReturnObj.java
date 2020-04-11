package com.boot.bootdemo.controller;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/25   10:19
 */
public class ReturnObj {

    private Integer code;

    private String msg;

    private Object object;

    public ReturnObj(Integer code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
