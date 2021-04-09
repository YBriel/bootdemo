package com.boot.bootdemo.config;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.boot.bootdemo.exception.AuthException;
import com.boot.bootdemo.exception.TokenException;
import com.boot.bootdemo.util.PrintStackTraceUtil;
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.UnexpectedTypeException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * author: yuzq
 * create: 2020-06-05 12:06
 **/
@RestControllerAdvice
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

/*    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handle(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError == null) {
            return RR.exp(MyExpEnum.PARAM_ERROR);
        }
        return RR.fail(fieldError.getDefaultMessage());
    }*/

/*    @ExceptionHandler({ConstraintViolationException.class})
    public Result<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return RR.fail(ex.getMessage());
    }*/

/*    @ExceptionHandler({UnexpectedTypeException.class})
    public Result<String> unexpectedTypeException(UnexpectedTypeException ex) {
        return RR.fail(ex.getMessage());
    }*/

/*    @ExceptionHandler({BindException.class})
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
    }*/

    /**
     * 用于   @DateTimeFormat(pattern = "yyyy-MM-dd") 校验
     * @param ex 异常
     * @return 锤子
     */
/*    @ExceptionHandler({InvalidFormatException.class})
    public Result<String> handleConstraintViolationException(InvalidFormatException ex) {
        Object value = ex.getValue();
        List<JsonMappingException.Reference> path = ex.getPath();
        String fieldName="";
        if(path!=null && path.size()>0){
            fieldName = path.get(0).getFieldName();
        }
        return RR.fail(fieldName+"格式有误"+value.toString());
    }*/

    @ExceptionHandler({NullPointerException.class})
    public Result<String> nullPointerException(NullPointerException ex) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        log.error("发送空指针异常了追溯代码为{},错误发送为{}",replace, PrintStackTraceUtil.getStackTraceInfo(ex));
        return RR.fail(MyExpEnum.SYS_ERROR.getDesc()+"错误代码为"+MyExpEnum.NULL_POINT_EXP.getCode()+"错误编号为"+replace);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception e) {
        String expNo = UUID.randomUUID().toString().replace("-", "");
        log.error("系统出了异常异常编号{},信息{}", expNo,e.getMessage());
        log.error("=============");
        log.error(PrintStackTraceUtil.getStackTraceInfo(e));
        Throwable cause = e.getCause();
        String message = "系统繁忙，请稍后再试!错误编码";
        if(cause!=null){
            message=cause.getMessage();
        }
        return RR.fail(message+"错误码"+expNo);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handle(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError == null) {
            return RR.fail("参数错误");
        }
        return RR.fail(fieldError.getField()+" "+fieldError.getDefaultMessage());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public Result<String> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

        if(CollectionUtils.isNotEmpty(constraintViolations)){
            ConstraintViolation<?> next = constraintViolations.iterator().next();
            String message = next.getMessage();
            Path propertyPath = next.getPropertyPath();

            String filed = propertyPath.toString();
            if(StringUtils.isNotEmpty(filed)){
                filed= filed.substring(filed.lastIndexOf(".")+1);
            }

            return RR.fail(filed+" "+message);

        }
        return RR.fail(ex.getMessage());
    }

    @ExceptionHandler({InvalidFormatException.class})
    public Result<String> handleConstraintViolationException(InvalidFormatException ex) {
        Object value = ex.getValue();
        List<JsonMappingException.Reference> path = ex.getPath();
        String fieldName="";
        if(path!=null && path.size()>0){
            fieldName = path.get(0).getFieldName();
        }
        return RR.fail(fieldName+"格式有误"+value.toString());
    }

    @ExceptionHandler({UnexpectedTypeException.class})
    public Result<String> unexpectedTypeException(UnexpectedTypeException ex) {
        return RR.fail(ex.getMessage());
    }

    @ExceptionHandler({JsonParseException.class})
    public Result<String> jsonParseException(JsonParseException ex) {
        return RR.fail("json参数格式有问题，百度搜索beJson检查");
    }

    @ExceptionHandler({BindException.class})
    public Result<String> bindException(BindException ex) {
        String msg="参数错误";
        if(ex!=null && ex.getFieldError()!=null){
            BindingResult bindingResult = ex.getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            if(fieldErrors.size() > 0){
                FieldError fieldError = fieldErrors.get(0);
                msg=fieldError.getField()+" "+fieldError.getDefaultMessage();
            }
        }
        return RR.fail(msg);
    }
}
