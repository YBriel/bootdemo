package com.boot.bootdemo.config.viewResolver;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

/**
 * author: yuzq
 * create: 2021-01-29 16:02
 **/
@Component
public class MyViewResolver implements ViewResolver, Ordered {


    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.startsWith("myView:")) {
            return new MyView();
        }
        return null;
    }
}
