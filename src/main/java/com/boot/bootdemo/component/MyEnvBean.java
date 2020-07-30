package com.boot.bootdemo.component;

import com.boot.bootdemo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * author: yuzq
 * create: 2020-07-30 18:52
 **/
@Configuration
public class MyEnvBean {

    @Conditional(EnvCondition.class)
    @Bean
    public Student student(){
        return new Student();
    }
}
