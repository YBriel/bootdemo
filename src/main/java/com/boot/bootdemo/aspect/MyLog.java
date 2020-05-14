package com.boot.bootdemo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/8   11:41
 */
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    String user() default "";

    String msg() default "";

}
