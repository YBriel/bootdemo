package com.boot.bootdemo.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * 发布事件
     * @param applicationEvent applicationEvent
     */
    public static void publishEvent(ApplicationEvent applicationEvent){
        if (applicationEvent != null) {
            applicationContext.publishEvent(applicationEvent);
        }
    }
}
