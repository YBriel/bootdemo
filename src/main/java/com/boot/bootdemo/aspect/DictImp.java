package com.boot.bootdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:26
 */
@Aspect
@Component
public class DictImp {
   // @Before("execution(* com.wuychn.springbootaspect.controller.*.*(..))") // 所有controller包下面的所有方法的所有参数
    //private HashMap<String,String> map=new HashMap<>();

    @Pointcut("")
    public void pointCut(){}


    public void beforeClass(JoinPoint joinPoint){}



    @Before("@annotation(com.boot.bootdemo.aspect.Dict)")
    public void beforeMethod(JoinPoint joinpoint) {

        Signature signature = joinpoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(Dict.class)) {

        }

    }


    @AfterReturning(value = "@annotation(com.boot.bootdemo.aspect.Dict)",returning = "obj")
    public void afterMethod(JoinPoint joinpoint,Object obj) throws IllegalAccessException {
        if(obj.getClass().getAnnotation(Dict.class)!=null){
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if(declaredField.getAnnotation(Dict.class)!=null){
                    declaredField.setAccessible(true);
                    declaredField.setInt(obj,456);
                }
            }
        }
        System.out.println("处理后"+obj);
    }

}
