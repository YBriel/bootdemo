package com.boot.bootdemo.config;


import lombok.Data;

/**
 * 百度接口调用返回
 * @param <T>
 */
@Data
 public class MyResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public MyResult(){
        this.code = 200;
        this.msg = "SUCCESS";
        this.data = null;
    }

    public MyResult(Integer code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public MyResult(Integer code,String message) {
        this.code=code;
        this.msg = message;
    }

    public MyResult<T> data(T data) {
        this.data = data;
        return this;
    }



    public MyResult<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public MyResult<T> message(String message) {
        this.msg = message;
        return this;
    }

    public static<T> MyResult<T> success(String message) {
        return new MyResult<>(200,message);
    }

    public static<T> MyResult<T> successData(String message,T data) {
        return new MyResult<>(200,message,data);
    }

    public static<T> MyResult<T> successData(T data) {
        return new MyResult<>(200,"success",data);
    }


    public static<T> MyResult<T> fail(String message) {
        return new MyResult<>(404,message);
    }

    public static<T> MyResult<T> error(String message) {
        return new MyResult<>(502,message);
    }

}
