package com.boot.bootdemo.entity;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/26   22:06
 */
public class MyBean  {

    public void test(BeanDefinitionRegistry beanDefinition, String name, Class<?> clazz){

        BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.genericBeanDefinition();
        //beanDefinition.registerBeanDefinition(name,);
    }

}
