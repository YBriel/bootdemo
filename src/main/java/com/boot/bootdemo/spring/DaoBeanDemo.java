package com.boot.bootdemo.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * author: yuzq
 * create: 2020-06-23 17:48
 **/
@Component("daoBeanDemo")
public class DaoBeanDemo implements FactoryBean<DaoBeanDemoTest> {

    @Override
    public DaoBeanDemoTest getObject() throws Exception {
        return new DaoBeanDemoTest();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void show(){
        System.out.println("this is DaoBeanDemo show ...");
    }
}
