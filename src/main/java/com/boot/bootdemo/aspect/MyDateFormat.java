package com.boot.bootdemo.aspect;

import org.springframework.format.annotation.DateTimeFormat;

import java.lang.annotation.*;

/**
 * author: yuzq
 * create: 2021-02-01 11:05
 **/

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
@Inherited
public @interface MyDateFormat{

    //DateTimeFormat dateFormat() default

}
