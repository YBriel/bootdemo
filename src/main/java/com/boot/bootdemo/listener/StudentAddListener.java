package com.boot.bootdemo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/9   11:12
 */
@Component
public class StudentAddListener implements ApplicationListener<StudentAddEvent> {

    @Override
    public void onApplicationEvent(StudentAddEvent studentAddEvent) {
        String info = studentAddEvent.getInfo();
        System.out.println("新增的信息************"+info);
    }
}
