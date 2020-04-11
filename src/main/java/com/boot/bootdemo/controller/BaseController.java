package com.boot.bootdemo.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/3/3   19:51
 */
public class BaseController {

    protected String token;
    protected String version;


    @ModelAttribute
    public void token(HttpServletRequest request){
        this.token = request.getHeader("token");
        this.version = request.getHeader("version");
    }
}
