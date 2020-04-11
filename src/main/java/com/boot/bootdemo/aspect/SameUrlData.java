package com.boot.bootdemo.aspect;

import java.lang.annotation.*;

/**
 * Title: SameUrlData
 * Description: 自定义注解防止表单重复提交
 * Author: yzq
 * Version: 1.0
 * create 2019/3/26 10:43
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SameUrlData {

}