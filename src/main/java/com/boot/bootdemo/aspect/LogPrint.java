package com.boot.bootdemo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: yuzq
 * create: 2021-04-28 13:09
 **/
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogPrint {


    String title() default "";

    String desc() default "";

    String note() default "";

    String requestId() default "";

}
