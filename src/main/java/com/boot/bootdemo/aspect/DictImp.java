package com.boot.bootdemo.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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


    public void beforeClass(JoinPoint joinPoint, ProceedingJoinPoint pd){}


/*    @Before("@annotation(com.boot.bootdemo.aspect.Dict)")
    public void beforeMethod(JoinPoint joinpoint) {

        Signature signature = joinpoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(Dict.class)) {

        }

    }*/


    @AfterReturning(value = "@annotation(com.boot.bootdemo.aspect.Dict)",returning = "obj")
    public void afterMethod(JoinPoint joinpoint,Object obj) throws IllegalAccessException {
        Map<String,Integer> map=new LinkedHashMap<>();
        if(obj.getClass().getAnnotation(Dict.class)!=null){
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (int i=0;i<declaredFields.length;i++) {
                Field declaredField = declaredFields[i];
                map.put(declaredField.getName(),i);
            }
            for (Field declaredField : declaredFields) {
                if(declaredField.getAnnotation(Dict.class)!=null){
                    Dict annotation = declaredField.getAnnotation(Dict.class);
                    String s = annotation.dictKey();
                    String s1 = annotation.dictName();
                    declaredField.setAccessible(true);
                    Object o = declaredField.get(obj);
                    String s3 = declaredField.getName() + "Str";
                    Integer integer = map.get(s3);
                    Field declaredField1 = declaredFields[integer];
                    Jedis jedis=new Jedis("39.107.138.128");
                    jedis.auth("123456");
                    String s4 = "dict:"+s1 + ":" + s + ":" + o.toString();
                    System.out.println("需要从redis获取的"+s4);
                    String s2 = jedis.get(s4);
                    System.out.println("redis获取的"+s2);
                    declaredField1.setAccessible(true);
                    declaredField1.set(obj, String.valueOf(s2));
                }
            }
        }
        //System.out.println("处理后"+obj);
    }
}
