package com.boot.bootdemo.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * author: yuzq
 * create: 2020-10-03 09:19
 **/
public class MyFactoryBean implements FactoryBean<MyFactoryBean> {
    @Override
    public MyFactoryBean getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
