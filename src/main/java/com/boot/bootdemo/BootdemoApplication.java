package com.boot.bootdemo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableAsync(proxyTargetClass = true)
//@ComponentScan(excludeFilters =@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = com.yzcx.onlinecar.config.CatFilterConfigure.class)) 排除类

public class BootdemoApplication  {


    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);

/*        System.out.println("哈哈哈哈哈哈哈");
        String myname = System.getProperty("myname");
        System.out.println(myname);
        System.out.println("哈哈哈哈哈哈哈");*/
    }

}
