package com.boot.bootdemo.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.description.annotation.AnnotationDescription;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-04-28 13:10
 **/
@Component
@Aspect
@Slf4j
public class LogPrintImpl  {

    @Before("@annotation(LogPrint)")
    public void doBefore(JoinPoint joinpoint)   {
        Signature signature = joinpoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        LogPrint logPrint = method.getAnnotation(LogPrint.class);
        InvocationHandler h = Proxy.getInvocationHandler(logPrint);
        Field requestField = null;
        try {
            requestField = h.getClass().getDeclaredField("memberValues");
            requestField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {

            Map<String,Object> memberValues = (Map<String,Object>) requestField.get(h);
            memberValues.put("requestId",System.currentTimeMillis()+"");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Object[] args = joinpoint.getArgs();
        String[] argNames = ((MethodSignature)joinpoint.getSignature()).getParameterNames(); // 参数名
        StringBuilder sb=new StringBuilder();
        if(argNames.length>0){
            for (int i=0;i<argNames.length;i++) {
                sb.append(argNames[i]).append(":").append(JSONObject.toJSONString(args[i])).append(",");
            }
        }
        log.info("requestId:{},title:{},desc:{},notes{},args:{}",logPrint.requestId(),logPrint.title(),logPrint.desc(),logPrint.note(),sb.toString());
    }

    @AfterReturning(value = "@annotation(LogPrint)",returning = "obj")
    public void doAfter(JoinPoint joinpoint,Object obj){
        Signature signature = joinpoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        LogPrint logPrint = method.getAnnotation(LogPrint.class);
        log.info("requestId:{},title:{},returnValue:{}",logPrint.requestId(), logPrint.title(),JSONObject.toJSON(obj));
    }
}
