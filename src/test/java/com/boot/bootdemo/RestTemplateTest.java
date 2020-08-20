package com.boot.bootdemo;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * author: yuzq
 * create: 2020-07-28 15:23
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RestTemplateTest {

   @Autowired
    private RestTemplate template;


    @Test
    public void test(){
        System.out.println(template.hashCode());
        String s = template.postForObject("www.baidu.com", "sss", String.class);
    }

    @Test
    public void test1(){
        ResponseEntity<byte[]> restTemplate = template.getForEntity("https://111.44.229.179/sp-jr5l5ozkv5k64m192bk6mjuum4iq/20081910030112056461784.wav?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200819T100630Z&X-Amz-SignedHeaders=host&X-Amz-Expires=604800&X-Amz-Credential=CEC70C94735204731F91%2F20200819%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=0272cb2fa1bc37baf961f3d27e2c3bcff62feeea634f6a3faec1827eb49bad16", byte[].class);
        HttpStatus statusCode = restTemplate.getStatusCode();
        byte[] body = restTemplate.getBody();

    }
}
