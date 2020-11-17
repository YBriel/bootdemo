package com.boot.bootdemo;

import org.apache.tomcat.util.security.MD5Encoder;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;

/**
 * author: yuzq
 * create: 2020-10-28 18:29
 **/
public class TestEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String aa="edrer";
        byte[] bytes = aa.getBytes();
        String encode = MD5Encoder.encode(bytes);
        System.out.println(encode);

    }
}
