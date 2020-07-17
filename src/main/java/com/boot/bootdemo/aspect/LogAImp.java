package com.boot.bootdemo.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:26
 */
@Aspect
@Component
//Order(1)
//@Order(Ordered.LOWEST_PRECEDENCE)
public class LogAImp implements Ordered{
   // @Before("execution(* com.wuychn.springbootaspect.controller.*.*(..))") // 所有controller包下面的所有方法的所有参数

    @Pointcut("")
    public void pointCut(){}

    @Before("@annotation(LogA)")
    public void beforeMethod(JoinPoint joinpoint){
        Signature signature = joinpoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        LogA logA = method.getAnnotation(LogA.class);
        Object[] args = joinpoint.getArgs();
        System.out.println(logA.action()+"___________________****"+logA.title()+"&&&&&&&-----"+JSON.toJSONString(args));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
