package com.boot.bootdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:26
 */
@Aspect
@Component
public class MyLogImpl {

    @Pointcut("")
    public void pointCut(){}


   // @Before()
    public void beforeClass(JoinPoint joinPoint){}



    @Before("@annotation(com.boot.bootdemo.aspect.LogA)")
    public void beforeMethod(JoinPoint joinpoint) {


    }
}
