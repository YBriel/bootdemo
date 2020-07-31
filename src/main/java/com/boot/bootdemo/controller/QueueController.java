package com.boot.bootdemo.controller;

import com.boot.bootdemo.config.MyLinkedListConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * author: yuzq
 * create: 2020-07-30 10:03
 **/
@RestController
@RequestMapping("queue")
@Slf4j
public class QueueController {

    @RequestMapping("/test")
    public String test(Long aa){
        MyLinkedListConfig.queue(aa);
        return "success";
    }

    @RequestMapping("/testHttp")
    public String testHttp(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        byte[] bytes=new byte[1024];
        int len;
        StringBuilder sb=new StringBuilder();
        while((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes),0, len);
        }
        String s = sb.toString();
        System.out.println(s);
        return sb.toString();
    }

    @PostMapping("/testHttpStr")
    public String testHttpStr(HttpServletRequest request,String aa) throws IOException {

        log.info("哈哈哈{}",aa);

        InputStream inputStream = request.getInputStream();
        StringBuffer requestURL = request.getRequestURL();
        String servletPath = request.getServletPath();
        byte[] bytes;
        bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println(read);
        String str = new String(bytes);
        System.out.println(str);
        return str;


       /* BufferedReader br = request.getReader();

        String str;
        StringBuilder wholeStr = new StringBuilder();
        while((str = br.readLine()) != null){
            wholeStr.append(str);
        }
        System.out.println(wholeStr);
        return wholeStr.toString();*/


/*    InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8");
    char [] buff=new char[1024];
    int length=0;
    while((length=reader.read(buff))!=-1) {
        String x = new String(buff, 0, length);
        System.out.println(x);
    }
    return "sss";*/
/*
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = request.getReader();) {
            char[]buff = new char[1024];
            int len;
            while((len = reader.read(buff)) != -1) {
                sb.append(buff,0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();*/
    }

}
