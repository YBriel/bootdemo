package com.boot.bootdemo;

import com.boot.bootdemo.login.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BootdemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void login(){
        Login login=new Login();
        login.login();
    }

}
