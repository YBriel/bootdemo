package com.boot.bootdemo.designpattern.strategy.spring;

import com.boot.bootdemo.entity.Hobby;
import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.entity.privateConstruct.YunClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Service;

/**
 * author: yuzq
 * create: 2021-03-06 10:40
 **/
@Service
@Slf4j
public class SaveOrderUtilDemo implements BeanDefinitionRegistryPostProcessor {

    /**
     * 先执行postProcessBeanDefinitionRegistry方法
     * 在执行postProcessBeanFactory方法
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registerBean(registry, "hello1", Student.class);
        registerBean(registry, "Hobby1", Hobby.class);
        registerBean(registry, "hobby2", YunClient.class);
        log.info("注册成功三个bean");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        YunClient bean = beanFactory.getBean(YunClient.class);

    }

    /**
     注册bean
     **/
    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
        RootBeanDefinition bean = new RootBeanDefinition(beanClass);
        registry.registerBeanDefinition(name, bean);
    }
}
