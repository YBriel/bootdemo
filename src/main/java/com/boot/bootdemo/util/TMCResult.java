package com.boot.bootdemo.util;

import lombok.Data;

/**
 * author: yuzq
 * create: 2021-01-22 10:28
 **/
@Data
public class TMCResult<T> {

    private String returnCode;
    private String returnMsg;
    private T businessResponse;


    public TMCResult(T businessResponse) {
        this.returnCode = "000";
        this.returnMsg = "SUCCESS";
        this.businessResponse = businessResponse;
    }

    public TMCResult(String returnMsg,T businessResponse) {
        this.returnCode = "000";
        this.returnMsg = returnMsg;
        this.businessResponse = businessResponse;
    }

    public TMCResult(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public TMCResult(String returnMsg) {
        this.returnCode = "001";
        this.returnMsg = returnMsg;
    }

    public TMCResult(String returnCode, String returnMsg, T businessResponse) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.businessResponse = businessResponse;
    }

    public static <T> TMCResult<T> success(T data){
        return new TMCResult<>(data);
    }

    public static <T> TMCResult<T> success(String msg,T data){
        return new TMCResult<>(data);
    }

    public static <T> TMCResult<T> fail(String returnCode, String returnMsg){
        return new TMCResult<>(returnCode,returnMsg);
    }
}
