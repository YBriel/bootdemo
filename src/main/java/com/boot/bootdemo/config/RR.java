package com.boot.bootdemo.config;

/**
 * author: yuzq
 * create: 2021-02-02 19:43
 **/

public class RR<T> {

    public static <T> Result<T> success() {
        Result <T> result = new Result<T>();
        result.setCode(0);
        result.setMsg("success");
        return result;
    }

    public static <T> Result<T> fail() {
        Result <T> result = new Result<T>();
        result.setCode(1);
        result.setMsg("fail");
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result <T> result = new Result<T>();
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result <T> result = new Result<T>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> exp(MyExpEnum expEnum) {
        Result <T> result = new Result<T>();
        result.setCode(expEnum.getCode());
        result.setMsg(expEnum.getDesc());
        return result;
    }
}
