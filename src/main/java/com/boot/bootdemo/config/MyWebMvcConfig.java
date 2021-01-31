package com.boot.bootdemo.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author: yuzq
 * create: 2021-01-31 17:09
 **/
@Configuration
@ServletComponentScan(value = "com.boot.bootdemo.servlet")
public class MyWebMvcConfig implements WebMvcConfigurer {


}
