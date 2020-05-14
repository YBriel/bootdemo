package com.boot.bootdemo.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:26
 */
@Aspect
@Component
public class LogAspect {
   // @Before("execution(* com.wuychn.springbootaspect.controller.*.*(..))") // 所有controller包下面的 所有方法的所有参数

    @Before("execution(void com.boot.bootdemo.login.Login.*(int))")
    public void beforeMethod(JoinPoint joinpoint){
        String signature = joinpoint.getSignature().getName();
        System.out.println("我呜呜呜呜呜呜呜呜无无无无无无无");
        System.out.println("前置增强 the method is "+signature+"=======参数为"+ JSON.toJSONString(joinpoint.getArgs()));
    }

    @AfterReturning(value = "execution(void com.boot.bootdemo.login.Login.*(int))",returning ="val" )
    public void afterReturning(JoinPoint joinpoint,Object val){
        System.out.println(val);
        String signature = joinpoint.getSignature().getName();
        System.out.println("我呜呜呜呜呜呜呜呜无无无无无无无");
        System.out.println("前置增强 the method is "+signature+"=======参数为"+ JSON.toJSONString(joinpoint.getArgs()));
    }
}
