package com.boot.bootdemo.entity.privateConstruct;

/**
 * author: yuzq
 * create: 2021-04-01 14:31
 **/
public class TestMain {


    public static void main(String[] args) {



        //有配置
        YunRequest request2=new YunRequest("hello","say");
        YunConfig config1=new YunConfig();
        YunClient.configure(config1);
        String request3 = YunClient.request(request2);
        System.out.println(request3);


        //没有配置
        YunRequest request=new YunRequest("hello","say");
        String request1 = YunClient.request(request);
        System.out.println(request1);



    }
}
