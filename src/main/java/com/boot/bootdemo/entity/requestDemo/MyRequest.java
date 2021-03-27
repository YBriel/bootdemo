package com.boot.bootdemo.entity.requestDemo;

/**
 * author: yuzq
 * create: 2021-03-27 15:40
 **/
public interface MyRequest {

    public String getCharacterEncoding();

    public Object getAttribute(String name);

    public int getContentLength();

    public String getContentType();
}
