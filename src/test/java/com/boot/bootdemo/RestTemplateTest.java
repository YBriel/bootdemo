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
import java.security.SecureRandom;
import java.util.*;

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

        for (int i = 0; i < 100; i++) {
            HttpHeaders headers = new HttpHeaders();
            HttpMethod method = HttpMethod.POST;
            // 以表单的方式提交
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            //将请求头部和参数合成一个请求  0e4ef6f9b027899a
            List<String> cookies =new ArrayList<>();
/*            cookies.add("route=dd60e19907652cdfc611cebdb619b76d;");
            cookies.add("TLKGUID=a5a38356-bc60-4522-8826-d8acb3cb0088;");
            cookies.add("Hm_lvt_422ba0de315b8a1aa8fcc86117369718=1605183563;");
            cookies.add("Hm_lpvt_422ba0de315b8a1aa8fcc86117369718=1605183565;");
            cookies.add("JSESSIONID=3191EF76A4C8FD8436FB0298FA98BF7F-n1");*/

            cookies.add("TLKGUID=840e854e-d1f8-41b0-9094-36224389c066;");
            cookies.add("JSESSIONID=E1DED247311E1E75343CA4709669C957-n1;");
            cookies.add("route=dd60e19907652cdfc611cebdb619b76d;");
            cookies.add("Hm_lvt_422ba0de315b8a1aa8fcc86117369718=1605185998;");
            cookies.add("Hm_lpvt_422ba0de315b8a1aa8fcc86117369718=1605186132");
            //cookies.add("JSESSIONID=3191EF76A4C8FD8436FB0298FA98BF7F-n1");
            headers.put(HttpHeaders.COOKIE,cookies);
            template.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
            MultiValueMap<String, String> params =new LinkedMultiValueMap<>();
            String guid = RandomTest.getGUID();
            params.add("code", guid);
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
            TianBack stringResponseEntity = template.postForObject("http://www.tlkg.com/mobileWeb/vip/getActivationCode.kg", requestEntity, TianBack.class);
            System.out.println(guid);
            System.out.println(JSONObject.toJSONString(stringResponseEntity));
        }

//        ResponseEntity<String> stringResponseEntity1 = template.postForEntity("http://www.tlkg.com/mobileWeb/vip/getActivationCode.kg", requestEntity, String.class);

       // System.out.println(stringResponseEntity);
    }

/*
 带参数
 public static String buildParam(String content){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String encryptKey = "C80A148A60554F4CB40A71A4C58820B9";
       // String nonce = MD5encryption(content);
        String now=String.valueOf(System.currentTimeMillis()/1000);
        //String checksum = encode(encryptKey, nonce, now);
        HttpEntity<String> request = new HttpEntity<>(content, headers);
        Map<String,String> params=new HashMap<>();
        String s1 = String.valueOf(new Date().getTime() / 1000);
        params.put("appKey","566afe8dbede1b2aa74ef7e9db7b318e");
       // params.put("checksum",checksum);
        params.put("time",s1);
     //   String s = restTemplate.postForObject("https://qiyukf.com/openapi/ic/task/add?appKey={appKey}&checksum={checksum}&time={time}", request, String.class,params);
      //  log.info("调用七鱼checksum{}time{}body{}返回信息{}",checksum,s1,content,s);
        return  s;
    }*/


/*
    传数组
   public static void listCurrentPos(List<PageDevice> data){
        String url="https://yhbb.hp888.com/open-api-test/devicestatus/listCurrentPos?deviceIds={deviceIds}";
        HttpHeaders httpHeaders=new HttpHeaders();
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        httpHeaders.add("Authorization","Bearer "+token);
        String[] strings = data.stream().map(PageDevice::getId).toArray(String[]::new);
        // params.put("deviceIds", Arrays.toString(strings));

        Map<String,String> params1=new HashMap<>();
        params1.put("deviceIds",Arrays.toString(strings));
        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        String  postForObject = restTemplate.postForObject(url,request, String.class,params1);
        System.out.println(postForObject.length());

    }*/


}
