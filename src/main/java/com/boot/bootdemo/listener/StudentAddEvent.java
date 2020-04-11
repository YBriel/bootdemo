package com.boot.bootdemo.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/9   11:10
 */
public class StudentAddEvent extends ApplicationEvent  {

    private Student student;

    public StudentAddEvent(Object source,Student student) {
        super(source);
        this.student=student;
    }

    public String getInfo(){
        return this.student.toString();
    }
}
