package com.boot.bootdemo.aspect;

import java.lang.annotation.*;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/8   11:41
 */
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface LogA {

    String title() default "";

    String action() default "";

}
