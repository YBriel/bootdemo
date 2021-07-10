package com.boot.bootdemo.sms.ali;

/**
 * 阿里短信审核枚举
 */
public enum AliTemplateCheckEnum {
    //0审核中 1审核通过 2审核失败

    CHECKING(0,"审核中"),
    PASSED(1,"审核通过"),
    FAIL(2,"审核失败");

    public Integer code;
    public String desc;

    AliTemplateCheckEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
