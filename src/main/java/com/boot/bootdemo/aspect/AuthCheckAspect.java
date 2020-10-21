package com.boot.bootdemo.aspect;

import com.alibaba.fastjson.JSON;
import com.boot.bootdemo.exception.TokenException;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/7/16   20:52
 */
@Component
@Aspect
public class AuthCheckAspect {

    @Autowired
    private HttpServletRequest request; //第一种获取请求request

    @Autowired
    private AsyncTask asyncTask;


    @Pointcut("@annotation(EnableAuthCheck)")
    public void pointCut(){}

    //@Before("pointCut()")
    public void checkAuth(){
        System.out.println("切点 before 开始执行");
        String token =(String) RequestContextHolder.getRequestAttributes().getAttribute("token", 0);
        System.out.println(token);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); //第二种获取数据
        String token1 = req.getHeader("token");
        System.out.println(token1);
        if(StringUtils.isEmpty(token1)){
            System.out.println("没带token");
            throw  new TokenException();
        }

        System.out.println("切点 before 结束执行");
/*

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            System.out.println("没带token");
            throw  new TokenException();
        }*/
    }


    @AfterReturning(value = "pointCut()",returning = "obj")
    public void afterReturning(JoinPoint joinPoint, Object obj) throws Exception {
        System.out.println("afterReturning... "+"切面执行returning");
        asyncTask.test();
        System.out.println(JSON.toJSONString(obj));
    }

   // @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("切面around开始");
        System.out.println("around... "+System.currentTimeMillis());
        Object[] args = joinPoint.getArgs();
        Object proceed = joinPoint.proceed(args);
        System.out.println("around... "+System.currentTimeMillis());
        System.out.println("切面around结束");
        return proceed;
    }

    //@After("pointCut()")
    public void afterAuth()throws Throwable{
        System.out.println(System.currentTimeMillis());
        System.out.println("切点 After 开始执行");
    }

    //@AfterThrowing("pointCut()")
    public void exceptionAuth(){
        System.out.println("切点 exceptionAuth 开始执行");
    }
}
