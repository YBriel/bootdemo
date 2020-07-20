package com.boot.bootdemo;

import com.boot.bootdemo.config.RedissonConfig;
import org.junit.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/7/20   20:44
 */
public class PartTestt {



    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RedissonConfig.class);
        RedissonClient redissonClient =(RedissonClient) applicationContext.getBean("red");
        RBucket<String> test = redissonClient.getBucket("test", StringCodec.INSTANCE);
        System.out.println(test.get());
    }


}
