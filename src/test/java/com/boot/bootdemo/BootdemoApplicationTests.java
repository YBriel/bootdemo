package com.boot.bootdemo;

import com.boot.bootdemo.login.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test(){
        for (int i = 0; i < 25; i++) {
            new Thread(()->{
                System.out.println("---"+redisTemplate.hashCode());
                String s = redisTemplate.opsForList().leftPop("demo");
                System.out.println(s);
//                System.out.println("---"+s+"====="+redisTemplate.hashCode());
            },i+"sss").start();
        }
    }

}
