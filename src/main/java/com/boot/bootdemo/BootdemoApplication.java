package com.boot.bootdemo;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableNacos(globalProperties = @NacosProperties(serverAddr = "122.51.250.57:8848"))
@EnableNacosDiscovery
@EnableDiscoveryClient
@EnableFeignClients

//@EnableAsync(proxyTargetClass = true)
public class BootdemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }

}
