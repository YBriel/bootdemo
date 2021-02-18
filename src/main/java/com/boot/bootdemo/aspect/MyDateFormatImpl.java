package com.boot.bootdemo.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * author: yuzq
 * create: 2021-02-01 11:05
 **/
@Aspect
@Component
public class MyDateFormatImpl {

    @Before("@annotation(MyDateFormat)")
    public void beforeMethod(JoinPoint joinpoint){
        Signature signature = joinpoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        MyDateFormat logA = method.getAnnotation(MyDateFormat.class);
        if(method.isAnnotationPresent(MyDateFormat.class)){
            Class<? extends MyDateFormat> aClass1 = logA.getClass();
            boolean annotationPresent1 = aClass1.isAnnotationPresent(DateTimeFormat.class);
            boolean annotationPresent = method.isAnnotationPresent(DateTimeFormat.class);
            if(annotationPresent){
                DateTimeFormat dateTimeFormat = method.getAnnotation(DateTimeFormat.class);
                method.setAccessible(true);
                Class<? extends DateTimeFormat> aClass = dateTimeFormat.getClass();
                System.out.println(aClass.getName());
            }
        }
        Object[] args = joinpoint.getArgs();
    }
}
