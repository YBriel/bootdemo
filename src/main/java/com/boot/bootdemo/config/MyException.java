package com.boot.bootdemo.config;

import com.boot.bootdemo.exception.AuthException;
import com.boot.bootdemo.exception.TokenException;
import com.boot.bootdemo.util.PrintStackTraceUtil;
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

/*    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public String authException(HttpServletResponse response){
        try {
            response.sendError(403);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "鉴权失败！";
    }*/

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public void authException(){

    }

   /* @ExceptionHandler(AuthException.class)
    //@ResponseBody
    public void authException(HttpServletResponse response){
        try {
            response.sendError(403);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


/*    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String nullPointerException(Exception e){
        log.error("空指针了",e);
        log.info("空指针错误{}", PrintStackTraceUtil.getStackTraceInfo(e));
        return "空指针了！";
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handle(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError == null) {
            return RR.exp(MyExpEnum.PARAM_ERROR);
        }
        return RR.fail(fieldError.getDefaultMessage());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public Result<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return RR.fail(ex.getMessage());
    }

    @ExceptionHandler({UnexpectedTypeException.class})
    public Result<String> unexpectedTypeException(UnexpectedTypeException ex) {
        return RR.fail(ex.getMessage());
    }

    @ExceptionHandler({BindException.class})
    public Result<String> bindException(BindException ex) {
        String msg=MyExpEnum.PARAM_ERROR.getDesc();
        if(ex!=null && ex.getFieldError()!=null){
            BindingResult bindingResult = ex.getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            if(fieldErrors.size() > 0){
                FieldError fieldError = fieldErrors.get(0);
                msg=fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return RR.fail(msg);
    }

    @ExceptionHandler({NullPointerException.class})
    public Result<String> nullPointerException(NullPointerException ex) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        log.error("发送空指针异常了追溯代码为{},错误发送为{}",replace, PrintStackTraceUtil.getStackTraceInfo(ex));
        return RR.fail(MyExpEnum.SYS_ERROR.getDesc()+"错误代码为"+MyExpEnum.NULL_POINT_EXP.getCode()+"错误编号为"+replace);
    }
}
