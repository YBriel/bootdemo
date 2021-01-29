package com.boot.bootdemo.config.viewResolver;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-01-29 16:14
 **/
public class MyView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect("http://localhost:8089/js/hello.html");
        System.out.println("走了这个");
    }
}
