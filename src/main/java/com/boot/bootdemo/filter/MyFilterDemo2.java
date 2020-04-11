package com.boot.bootdemo.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/24   16:47
 */
public class MyFilterDemo2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
