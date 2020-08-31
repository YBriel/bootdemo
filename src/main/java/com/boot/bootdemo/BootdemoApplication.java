package com.boot.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableAsync(proxyTargetClass = true)
public class BootdemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }

}
