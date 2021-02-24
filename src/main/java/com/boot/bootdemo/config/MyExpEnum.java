package com.boot.bootdemo.config;

/**
 * author: yuzq
 * create: 2021-02-03 20:23
 **/
public enum MyExpEnum {

    ERROR(999,"参数错误!"),
    PARAM_ERROR(9001,"参数错误!"),
    REPEAT_REQUEST(9002,"请求正在处理，请勿重复请求!"),
    SYS_ERROR(9003,"系统繁忙请稍后再试!"),
    OPERATE_MONEY_ERROR(9004,"操作金额有误!"),
    NULL_POINT_EXP(60001,"空指针错误!"),
    USER_DOESNT_EXIST(9005,"用户不存在!");



    private Integer code;

    private String desc;

    MyExpEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
