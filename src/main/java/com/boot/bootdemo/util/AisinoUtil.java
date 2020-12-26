package com.boot.bootdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;

/**
 * author: yuzq
 * create: 2020-12-22 17:02
 **/
@Slf4j
public class AisinoUtil {

    private static RestTemplate restTemplate;

    static {
        restTemplate=new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(3000);
        restTemplate.setRequestFactory(requestFactory);
        log.info("航天开票初始化restTemplate完成...");
    }

    public void getPdfByUrl(String url) throws IOException {
       // restTemplate.postForObject()
        ResponseEntity<byte[]> forEntity = restTemplate.getForEntity(url, byte[].class);
        HttpStatus statusCode = forEntity.getStatusCode();
        log.info("返回的状态码为{}",statusCode);
        byte[] body = forEntity.getBody();
        File file=new File("aap.pdf");
        //FileUtils.writeByteArrayToFile(file,body);

        assert body != null;
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(body);
        //log.info("加密后{}",encode);
        Base64ToPdf.base64StringToPdf(encode,"D:aaa1.pdf");
        boolean delete = file.delete();
        log.info("文件{}删除{}",file.getName(),delete);
    }

    public static void main(String[] args) throws IOException {
        AisinoUtil a=new AisinoUtil();
        a.getPdfByUrl("https://inv.jss.com.cn/fp/8ZLSI6Y-vhjsfNGdgGRK4-996BLB8AoLZZMkyYLU8yin8wFDG9LRkW95xXdP_hyUvqlxyfBu_Bsk6daEKAqANw.pdf");
    }


}
