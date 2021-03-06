package com.boot.bootdemo.config;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/6/14   20:40
 */
@Configuration
public class MyRedisTemplate {

    @Bean(name = "httpsRest")
  //  @LoadBalanced
    public RestTemplate restTemplate() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
        }}, new java.security.SecureRandom());
        HostnameVerifier ignoreHostnameVerifier = (s, sslsession) -> {
            System.out.println("WARNING: Hostname is not matched for cert.");
            return true;
        };
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext,ignoreHostnameVerifier);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        //处理中文乱码
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
    //@Bean
    public StringRedisTemplate redisTemplate(){
        return new StringRedisTemplate();
    }

    @Bean
    public RestTemplate template(){
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory=new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(500);
        simpleClientHttpRequestFactory.setReadTimeout(500);
       // restTemplate.getMessageConverters().add()
        restTemplate.getInterceptors().add(new MyRestTemplateInterceptor());
        restTemplate.setRequestFactory(simpleClientHttpRequestFactory);
        return new RestTemplate();
    }
}
