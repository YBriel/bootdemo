package com.boot.bootdemo;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("hhh");
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setReadTimeout(500);
        simpleClientHttpRequestFactory.setConnectTimeout(500);
        template.setRequestFactory(simpleClientHttpRequestFactory);
        String s = template.getForObject("http://localhost:8000/world", String.class);
    }

    @Test
    public void test1(){
        ResponseEntity<byte[]> restTemplate = template.getForEntity("https://111.44.229.179/sp-jr5l5ozkv5k64m192bk6mjuum4iq/20081910030112056461784.wav?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200819T100630Z&X-Amz-SignedHeaders=host&X-Amz-Expires=604800&X-Amz-Credential=CEC70C94735204731F91%2F20200819%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=0272cb2fa1bc37baf961f3d27e2c3bcff62feeea634f6a3faec1827eb49bad16", byte[].class);
        HttpStatus statusCode = restTemplate.getStatusCode();
        byte[] body = restTemplate.getBody();

    }
    @Test
    public void test3(){
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        List<String> cookies =new ArrayList<>();
        cookies.add("route=dd60e19907652cdfc611cebdb619b76d;");
        cookies.add("TLKGUID=a5a38356-bc60-4522-8826-d8acb3cb0088;");
        cookies.add("Hm_lvt_422ba0de315b8a1aa8fcc86117369718=1605183563;");
        cookies.add("Hm_lpvt_422ba0de315b8a1aa8fcc86117369718=1605183565;");
        cookies.add("Hm_lpvt_422ba0de315b8a1aa8fcc86117369718=1605183565;");
        cookies.add("JSESSIONID=3191EF76A4C8FD8436FB0298FA98BF7F-n1");
        headers.put(HttpHeaders.COOKIE,cookies);
        template.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        MultiValueMap<String, String> params =new LinkedMultiValueMap<>();
        params.add("code","12313");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        String stringResponseEntity = template.postForObject("http://www.tlkg.com/mobileWeb/vip/getActivationCode.kg", requestEntity, String.class);
        byte[] bytes = stringResponseEntity.getBytes();
        String s = new String(bytes, Charset.defaultCharset());
        System.out.println(s);
        ResponseEntity<String> stringResponseEntity1 = template.postForEntity("http://www.tlkg.com/mobileWeb/vip/getActivationCode.kg", requestEntity, String.class);

        System.out.println(stringResponseEntity);
    }
}
