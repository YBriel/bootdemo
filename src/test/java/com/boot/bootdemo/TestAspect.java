package com.boot.bootdemo;

import com.boot.bootdemo.listener.Student;
import com.boot.bootdemo.listener.StudentAddEvent;
import com.boot.bootdemo.login.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:52
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BootdemoApplication.class)
public class TestAspect {

    @Autowired
    private  ApplicationContext applicationContext;

    @Autowired
    private Login login;

    @Test
    public void login(){
       // Login login=new Login();
        login.login("s",1,"d");
        System.out.println("---");
    }

    @Test
    public void testListener(){
        Student student=new Student("tom","111");
        StudentAddEvent studentAddEvent=new StudentAddEvent(this,student);
        applicationContext.publishEvent(studentAddEvent);
    }

}
