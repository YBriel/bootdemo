package com.boot.bootdemo.config;

import com.boot.bootdemo.exception.TokenException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: yuzq
 * create: 2020-06-05 12:06
 **/
@ControllerAdvice
public class MyException {

    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    public String mySQLIntegrityConstraintViolationException(){
        return "主键重复了";
    }

    @ExceptionHandler(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public String mySQLIntegrityConstraintViolationExcepti(){
        return "主键重复了";
    }

    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public String tokenException(){
        return "鉴权失败！";
    }


}
