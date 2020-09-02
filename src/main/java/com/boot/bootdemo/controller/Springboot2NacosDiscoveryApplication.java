package com.boot.bootdemo.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

//curl -X PUT 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=springboot2-nacos-discovery&ip=127.0.0.1&port=8080'
@RestController
public class Springboot2NacosDiscoveryApplication {

    @NacosInjected
    private NamingService namingService;

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @PostConstruct
    public void registerInstance() throws NacosException{
        System.out.println(this.serverPort);
        System.out.println(this.applicationName);
        //namingService.registerInstance(applicationName,"127.0.0.1",8089);
        System.out.println("注册了....");
    }

    @RequestMapping(value = "/getInstance", method = GET)
    @ResponseBody
    public List<Instance> getInstance(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}