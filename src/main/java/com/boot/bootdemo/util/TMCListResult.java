package com.boot.bootdemo.util;

import lombok.Data;

import java.util.List;

/**
 * author: yuzq
 * create: 2021-01-22 10:28
 **/
@Data
public class TMCListResult<T> {

    private String returnCode;
    private String returnMsg;
    private List<T> businessResponse;


    public TMCListResult(List<T> businessResponse) {
        this.returnCode = "000";
        this.returnMsg = "SUCCESS";
        this.businessResponse = businessResponse;
    }

    public TMCListResult(String returnMsg, List<T> businessResponse) {
        this.returnCode = "000";
        this.returnMsg = returnMsg;
        this.businessResponse = businessResponse;
    }

    public TMCListResult(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public TMCListResult(String returnMsg) {
        this.returnCode = "001";
        this.returnMsg = returnMsg;
    }

    public TMCListResult(String returnCode, String returnMsg, List<T> businessResponse) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.businessResponse = businessResponse;
    }

    public static <T> TMCListResult<T> success(List<T> data){
        return new TMCListResult<>(data);
    }

    public static <T> TMCListResult<T> success(String msg, List<T> data){
        return new TMCListResult<>(data);
    }

    public static <T> TMCListResult<T> fail(String returnCode, String returnMsg){
        return new TMCListResult<>(returnCode,returnMsg);
    }
}
