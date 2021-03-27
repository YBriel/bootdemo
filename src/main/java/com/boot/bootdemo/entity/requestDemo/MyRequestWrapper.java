package com.boot.bootdemo.entity.requestDemo;

import javax.servlet.ServletRequest;

/**
 * author: yuzq
 * create: 2021-03-27 15:41
 **/
public class MyRequestWrapper implements MyRequest {

    private MyRequest request;

    public MyRequestWrapper(MyRequest request) {
        this.request = request;
    }

    public MyRequest getRequest() {
        return request;
    }


    public void setRequest(MyRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        this.request = request;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public String getContentType() {
        return null;
    }
}
