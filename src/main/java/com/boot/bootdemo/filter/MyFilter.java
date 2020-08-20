package com.boot.bootdemo.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
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
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String name = request.getHeader("name");
        System.out.println("获取到了头"+name);
        if(name.equals("tom")){
            System.out.println("获取到了头");
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            System.out.println("没有过滤成功！");
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器destroy方法执行");
    }
}
