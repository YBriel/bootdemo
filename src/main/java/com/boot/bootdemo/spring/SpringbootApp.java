package com.boot.bootdemo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: yuzq
 * create: 2020-06-23 17:53
 **/

public class SpringbootApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        //加上&是获取FactoryBean 对象 不加是获取FactoryBean getObject对象本身
        DaoBeanDemo daoBeanDemo =(DaoBeanDemo) annotationConfigApplicationContext.getBean("&daoBeanDemo");
        daoBeanDemo.show();
    }
}
