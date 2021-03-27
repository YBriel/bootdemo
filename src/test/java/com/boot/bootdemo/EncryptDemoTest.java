package com.boot.bootdemo;

import com.alibaba.fastjson.JSONObject;
import com.boot.bootdemo.entity.Student;

import java.util.Base64;

/**
 * author: yuzq
 * create: 2021-03-27 10:26
 **/
public class EncryptDemoTest {


    public static void main(String[] args) {

        String s = new String(Base64.getEncoder().encode("hello".getBytes()));
        System.out.println(s);
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        System.out.println(new String(decode));

        Student student = new Student();
        student.setAge(1);
        student.setName("tom");
        String s1 = JSONObject.toJSONString(student);
        System.out.println(s1);
        String s2 = new String(Base64.getEncoder().encode(s1.getBytes()));
        System.out.println(s2);
        byte[] decode2 = Base64.getDecoder().decode(s2.getBytes());
        System.out.println(new String(decode2));

    }
}
