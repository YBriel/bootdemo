package com.boot.bootdemo.config;

/**
 * Author:yuzq
 * date: 11:21 2020 04 25
 */
public class MyResultUtil<T> {
    /*public static <T> MyResult<T> succ(T t) {
        MyResult <T> result = new MyResult<T>();
        result.setCode(0);
        result.setMsg("SUCCESS");
        result.setData(t);
        return result;
    }*/

    public static  <T> MyResult<T> succ() {
        return succ(null);
    }


    public static   <T> MyResult<T>  fail(Integer code, String msg) {
        MyResult <T> result = new MyResult<T>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> MyResult<T> succ(T t) {
        return MyResult.successData(t);
    }
}
