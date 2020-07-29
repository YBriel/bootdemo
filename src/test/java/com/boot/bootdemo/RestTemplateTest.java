package com.boot.bootdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * author: yuzq
 * create: 2020-07-28 15:23
 **/
@SpringBootTest
public class RestTemplateTest {

   @Autowired
    private RestTemplate template;


    @Test
    public void test(){
        System.out.println(template.hashCode());
        String s = template.postForObject("www.baidu.com", "sss", String.class);
    }
}
