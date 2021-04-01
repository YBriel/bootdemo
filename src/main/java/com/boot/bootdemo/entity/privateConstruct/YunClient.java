package com.boot.bootdemo.entity.privateConstruct;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * author: yuzq
 * create: 2021-04-01 13:44
 **/
@Slf4j
public class YunClient {

    private static YunConfig yunConfig;


    private YunClient() {

    }


    public static void configure(YunConfig config){
        log.info("配置开始{}", JSONObject.toJSONString(config));
        YunClient.yunConfig=config;
    }

    public static String request(YunRequest request){
        Assert.notNull(yunConfig,"请先初始化配置文件...");
        Assert.notNull(request,"请求不能为空...");
        return   post(request);
    }

    private static String post(YunRequest request){
        log.info("请求成功");

        return request.getMethod();
    }

}
