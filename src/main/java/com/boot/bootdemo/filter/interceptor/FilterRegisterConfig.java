package com.boot.bootdemo.filter.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegisterConfig {

    @Autowired
    private HttpServletRequestReplacedFilter httpServletRequestReplacedFilter;

    @Bean
    public FilterRegistrationBean<HttpServletRequestReplacedFilter> filterRegistrationBean() {
        FilterRegistrationBean<HttpServletRequestReplacedFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(httpServletRequestReplacedFilter);
        //拦截所有的请求，给每个请求都包装一下，拦截器中再判断是否需要拦截处理
      //  registrationBean.addUrlPatterns("/tl/*");
        registrationBean.addUrlPatterns("/tl/test2");
        //给自定义的filter设置顺序，值越小，优先级越高，建议可以稍微高一些，防止影响框架的一些filter
        registrationBean.setOrder(10);
        return registrationBean;
    }
}