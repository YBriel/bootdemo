package com.boot.bootdemo;

import com.boot.bootdemo.config.MyLinkedListConfig;
import com.boot.bootdemo.spring.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

@SpringBootApplication
//@EnableAsync(proxyTargetClass = true)
public class BootdemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }



}
