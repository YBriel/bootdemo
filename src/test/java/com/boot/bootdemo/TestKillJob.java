package com.boot.bootdemo;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-05-10 10:54
 **/
public class TestKillJob {

    private static RestTemplate restTemplate;

    static {
        restTemplate=new RestTemplate();
    }


    @Test
    public void test1(){

        for (int i = 2801; i < 2890; i++) {
            HttpHeaders headers=new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("Cookie","XXL_JOB_LOGIN_IDENTITY=7b226964223a332c22757365726e616d65223a2279757a71222c2270617373776f7264223a226635656637623965376466303031656134393138623936316232616537393737222c22726f6c65223a312c227065726d697373696f6e223a22227d");
            Map<String,Object> map=new HashMap<>();
            map.put("id",i);
            HttpEntity<String> entity=new HttpEntity<>(headers);
            String s = restTemplate.postForObject("http://8.140.7.220:9998/onlinecar-schedule-admin/joblog/logKill?id={id}", entity, String.class,map);
            System.out.println(s);
        }

    }
}


