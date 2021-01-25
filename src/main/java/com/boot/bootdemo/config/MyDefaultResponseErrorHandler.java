package com.boot.bootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * description:
 * author: yuzq
 * date: 2020/5/26 15:47
 */
@Slf4j
public class MyDefaultResponseErrorHandler extends DefaultResponseErrorHandler {

    protected void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {

        String statusText = response.getStatusText();
        HttpHeaders headers = response.getHeaders();
        byte[] body = getResponseBody(response);
        System.out.println("第二个返回"+new String(body));

        InputStream body1 = response.getBody();
        byte[] bytes;
        bytes = new byte[body1.available()];
        int read = body1.read(bytes);
        String str = new String(bytes);
        System.out.println("第一个返回"+str);
        Charset charset = getCharset(response);
        switch (statusCode.series()) {
            case CLIENT_ERROR:
                throw HttpClientErrorException.create(statusCode, statusText, headers, body, charset);
            case SERVER_ERROR:
                log.info("服务器捕获到了异常，状态码{},body为{}",statusCode.value(),new String(body));
                throw new RuntimeException(new String(body));
               // throw new MyHttpException(statusCode.value(), new String(body));
            default:
                throw new UnknownHttpStatusCodeException(statusCode.value(), statusText, headers, body, charset);
        }
    }
}
