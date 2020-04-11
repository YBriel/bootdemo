package com.boot.bootdemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author： yuzq
 * Description: 分页插件配置
 * Date: 2019/7/30   11:46
 */
@Configuration
@EnableTransactionManagement
public class MybatisPlusConf {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }


}
