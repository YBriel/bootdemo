package com.boot.bootdemo;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@SpringBootApplication
//@EnableNacosDiscovery
//@EnableDiscoveryClient
//@EnableFeignClients

//@EnableAsync(proxyTargetClass = true)
public class BootdemoApplication  {


    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }



/*
    @PostConstruct
    public void regist() throws NacosException {
       // namingService.registerInstance("bootdemo", "127.0.0.1", 8089,"DEFAULT_GROUP");
        NamingService naming = NamingFactory.createNamingService("122.51.250.57");
        naming.registerInstance("bootdemo", "127.0.0.1", 8089);
    }*/
}
