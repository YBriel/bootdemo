package com.boot.bootdemo;

import com.boot.bootdemo.coupon.MyStrategy;
import com.boot.bootdemo.listener.OrderEvent;
import com.boot.bootdemo.listener.Student;
import com.boot.bootdemo.listener.StudentAddEvent;
import com.boot.bootdemo.login.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.BeanInfo;
import java.util.Map;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:52
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = BootdemoApplication.class)
public class TestAspect {

    @Autowired
    private  ApplicationContext applicationContext;

    @Autowired
    private Login login;

    @Autowired
    private RedissonClient redisson;

    @Test
    public void login(){
       // Login login=new Login();

        System.out.println("---");
    }

    @Test
    public void testListener(){
        Student student=new Student("tom","111");
        StudentAddEvent studentAddEvent=new StudentAddEvent(this,student);
        applicationContext.publishEvent(studentAddEvent);
    }

    @Test
    public void test1(){
        OrderEvent orderEvent=new OrderEvent("我发布了消息啊");
        applicationContext.publishEvent(orderEvent);
    }

    @Test
    public void test(){
        RBucket<Object> test = redisson.getBucket("test", StringCodec.INSTANCE);

        //System.out.println(test.get());
    }


}
