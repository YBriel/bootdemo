package com.boot.bootdemo.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/20   8:39
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器init方法执行");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器doFilter方法执行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器destroy方法执行");
    }
}
