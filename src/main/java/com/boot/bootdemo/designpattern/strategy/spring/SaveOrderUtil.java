package com.boot.bootdemo.designpattern.strategy.spring;

import com.boot.bootdemo.entity.Hobby;
import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.spring.autowiredMap.DataServiceDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: yuzq
 * create: 2021-03-06 10:40
 **/
@Service
@Slf4j
public class SaveOrderUtil implements ApplicationContextAware {

    @Autowired
    private List<ISaveOrder> saveOrders;

    @Autowired
    private Map<String, ISaveOrder> map = new ConcurrentHashMap<>();

    private ApplicationContext applicationContext;



    public ISaveOrder selectService(String name) {
        return map.get(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext=applicationContext;
//        ClassPathXmlApplicationContext parentBeanFactory =(ClassPathXmlApplicationContext) applicationContext.getParentBeanFactory();
//        parentBeanFactory.getBeanFactory().registerSingleton("myBeanStu",new Student());
//        log.info("初始化完成我自己的bean{}","myBeanStu");
//        Object myBeanStu = applicationContext.getBean("myBeanStu");
        Student hello1 = applicationContext.getBean("hello1", Student.class);
        Hobby hobby1 = applicationContext.getBean("Hobby1", Hobby.class);
        log.info("哈哈哈");

    }
}
