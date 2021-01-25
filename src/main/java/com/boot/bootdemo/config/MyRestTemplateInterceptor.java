package com.boot.bootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * author: yuzq
 * create: 2021-01-23 10:36
 **/
@Slf4j
public class MyRestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("请求地址{},请求体{},执行器{}",request.getURI(),new String(body),execution.toString());
        ClientHttpResponse response = execution.execute(request, body);
        log.info("返回信息为{}",response.getStatusCode());
        return response;
    }
}
