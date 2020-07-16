package com.boot.bootdemo.aspect;

import com.boot.bootdemo.exception.TokenException;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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


    @Pointcut("@annotation(EnableAuthCheck)")
    public void pointCut(){}

    //@Before("pointCut()")
    public void checkAuth(){
        System.out.println("切点开始执行");
        String token =(String) RequestContextHolder.getRequestAttributes().getAttribute("token", 0);
        System.out.println(token);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); //第二种获取数据
        String token1 = req.getHeader("token");
        System.out.println(token1);
        if(StringUtils.isEmpty(token)){
            System.out.println("没带token");
            throw  new TokenException();
        }

/*

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            System.out.println("没带token");
            throw  new TokenException();
        }*/
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around开始");
        Object[] args = joinPoint.getArgs();
        joinPoint.proceed(args);
    }
}
