package com.boot.bootdemo.config;

import com.boot.bootdemo.exception.TokenException;
import com.boot.bootdemo.util.PrintStackTraceUtil;
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: yuzq
 * create: 2020-06-05 12:06
 **/
@ControllerAdvice
@Slf4j
public class MyException {

/*    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    public String mySQLIntegrityConstraintViolationException(){
        return "主键重复了";
    }

    @ExceptionHandler(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public String mySQLIntegrityConstraintViolationExcepti(){
        return "主键重复了";
    }*/

    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public String tokenException(){
        return "鉴权失败！";
    }


    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String nullPointerException(Exception e){
        log.error("空指针了",e);
        log.info("空指针错误{}", PrintStackTraceUtil.getStackTraceInfo(e));
        return "空指针了！";
    }
}
