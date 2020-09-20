package com.boot.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAsync(proxyTargetClass = true)
public class BootdemoApplication  {


    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }

}
