package com.boot.bootdemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * author: yuzq
 * create: 2021-03-15 14:56
 **/
@Service
public class TmcTransUtil<T> {

    private RestTemplate template;

    public static HttpEntity<Map<String, Object>> headers(Map<String, Object> map) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new HttpEntity<>(map, headers);
    }

    public static HttpEntity<String> headersStr(Map<String, Object> map,String requestType) {
        return getStringHttpEntity(map, requestType);
    }

    public static HttpEntity<String> getStringHttpEntity(Object map, String requestType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String, Object> param=new HashMap<>();
        param.put("header", getSignature(requestType));
        param.put("businessRequest",map);
        return new HttpEntity<>(JSON.toJSONString(param), headers);
    }

    public static HeaderContent getSignature(String requestType){
        Date date = new Date();
        long time = date.getTime();
        String partnerCode="P10000119";
        String signature = DigestUtils.md5Hex(time+partnerCode+DigestUtils.md5Hex("rv94xzlm6ubyZEQC2JdGS4LV").toUpperCase()+requestType).toUpperCase();
//        System.out.println("时间"+time);
//        System.out.println("秘钥"+signature);
        return  HeaderContent.build(requestType,signature,time);
    }


    public T post(Map<String, Object> map, String methodName, Class<T> responseType) {
        return template.postForObject("http://www.fangcang.com/tmc-hub/" + methodName, headersStr(map, methodName), responseType);
    }

    private static TmcBack transferTo(String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String returnCode = jsonObject.getString("retrunCode");
        String returnMsg = jsonObject.getString("retrunMsg");
        JSONObject response = jsonObject.getJSONObject("bussinessResponse");
        return new TmcBack(returnCode, returnMsg, response);
    }

    public TMCResult<T> postBack(Map<String, Object> map, String methodName,Class<T> responseType) {
        TmcBack back = transferTo(template.postForObject("http://www.fangcang.com/tmc-hub/" + methodName, headersStr(map, methodName), String.class));
        if (StringUtils.isNotEmpty(back.getCode()) && back.getCode().equals("000")) {
            T businesses = back.getData().getObject("businesses", responseType);
            return TMCResult.success(back.getDesc(), businesses);
        }
        return TMCResult.fail(back.getCode(), back.getDesc());
    }

    public TMCListResult<T> postBack(Map<String, Object> map, String methodName, Class<T> responseType, Integer list) {
        TmcBack back = transferTo(template.postForObject("http://www.fangcang.com/tmc-hub/" + methodName, headersStr(map, methodName), String.class));
        if (StringUtils.isNotEmpty(back.getCode()) && back.getCode().equals("000")) {
            List<T> ts = JSONObject.parseArray(back.getData().getString("businesses"), responseType);
            return TMCListResult.success(back.getDesc(), ts);
        }
        return TMCListResult.fail(back.getCode(), back.getDesc());
    }



    public TMCResult<T> postBack(Object map, String methodName,Class<T> responseType) {
        TmcBack back = transferTo(template.postForObject("http://www.fangcang.com/tmc-hub/" + methodName, getStringHttpEntity(map, methodName), String.class));
        if (StringUtils.isNotEmpty(back.getCode()) && back.getCode().equals("000")) {
            T businesses = back.getData().getObject("businesses", responseType);
            return TMCResult.success(back.getDesc(), businesses);
        }
        return TMCResult.fail(back.getCode(), back.getDesc());
    }

    public TMCListResult<T> postBack(Object map, String methodName, Class<T> responseType, Integer list) {
        TmcBack back = transferTo(template.postForObject("http://www.fangcang.com/tmc-hub/" + methodName, getStringHttpEntity(map, methodName), String.class));
        if (StringUtils.isNotEmpty(back.getCode()) && back.getCode().equals("000")) {
            List<T> ts = JSONObject.parseArray(back.getData().getString("businesses"), responseType);
            return TMCListResult.success(back.getDesc(), ts);
        }
        return TMCListResult.fail(back.getCode(), back.getDesc());
    }


}
