package com.boot.bootdemo.sms.ali;

/**
 * 阿里消息模板类型
 */

public enum AliTemplateTypeEnum {

    //0验证码 1短信通知 2推广短信 3国际/港澳台消息
    VERIFY_CODE(0,"验证码"),
    SMS_INFO(1,"短信通知"),
    ADVERTISE(2,"推广短信"),
    INTERNATIONAL(3,"国际/港澳台消息");

    public Integer code;
    public String desc;

    AliTemplateTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
