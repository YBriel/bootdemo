package com.boot.bootdemo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * author: yuzq
 * create: 2020-05-30 13:29
 **/
//@Component
/*public class MyBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
        System.out.println(beanNamesIterator.next());
    }
}*/
