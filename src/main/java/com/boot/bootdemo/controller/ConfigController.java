package com.boot.bootdemo.controller;

import com.boot.bootdemo.config.MyConfig;
import com.boot.bootdemo.config.TestConfig;
import com.boot.bootdemo.exception.AuthException;
import com.boot.bootdemo.util.PropertyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * author: yuzq
 * create: 2020-10-21 09:20
 **/
@RestController
@RequestMapping("config")
@Slf4j
public class ConfigController {

    @Autowired
    private MyConfig config;

    @Autowired
    private TestConfig config1;

    @RequestMapping("test1")
    public String test1(){
        Map<String, String> map = MyConfig.getMap();
        if(map.get("name").equals("tom")){
            return "tom";
        }else {
            return map.get("name");
        }
    }

    @RequestMapping("test")
    public String setMap(String name){
        Map<String, String> map = MyConfig.getMap();
        map.put("name",name);
        log.info("插入的名称为{}",name);
        return name;
    }
    @RequestMapping("getProperty")
    public String getProperty(String key){
         return PropertyUtil.getProperties(key);
    }

    @RequestMapping("setProperty")
    public Object setProperty(String key,String value){
        return PropertyUtil.setProperties(key,value);
    }

    @RequestMapping("getCon")
    public String getCon(){
        return config1.nap();
    }

    @RequestMapping("getAge")
    public String getAge(){
        return config1.ageGet();
    }

    @RequestMapping("getStatus")
   // @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "请求参数异常!")
    public String getStatus(HttpServletResponse response) throws IOException {
       response.setStatus(403); //状态码 效果只有状态码变
        //  response.sendError(403);//设置返回错误。没有权限
        response.setHeader("name","tom");
        response.setDateHeader("dat",new Date().getTime());
        return config1.ageGet();
    }

    @RequestMapping("getStatus1")
    public String getStatus1(Integer a){
        if(a>2){
            throw new AuthException("是是是");
        }
        return config1.ageGet();
    }
}
