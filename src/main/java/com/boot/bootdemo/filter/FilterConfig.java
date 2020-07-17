package com.boot.bootdemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/24   16:35
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistration(){
        FilterRegistrationBean<MyFilter> filterRegistration=new FilterRegistrationBean<>();
        filterRegistration.setFilter(new MyFilter());
        filterRegistration.addUrlPatterns("/queryStu");
        filterRegistration.addInitParameter("ERR_URL", "储物袋");
        return filterRegistration;
    }

    //@Bean
    public FilterRegistrationBean<MyFilterDemo> myMyFilterDemo(){
        System.out.println("这是过滤器！！！！！");
        FilterRegistrationBean<MyFilterDemo> filterRegistration=new FilterRegistrationBean<>();
        filterRegistration.setFilter(new MyFilterDemo());
        filterRegistration.addUrlPatterns("/queryStu");
        filterRegistration.addInitParameter("ERR_URL", "储物袋");
        return filterRegistration;
    }


    /**
     * 自定义静态资源路径
     *
     * @return
     */
    public List<String> defineResourcePaths() {
        List<String> patterns = new ArrayList<>();
        patterns.add("/assets/**");
        patterns.add("/upload/**");
        patterns.add("/static/**");
        patterns.add("/common/**");
        patterns.add("/error");
        return patterns;
    }
}
