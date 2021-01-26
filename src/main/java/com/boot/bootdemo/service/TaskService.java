package com.boot.bootdemo.service;

import com.boot.bootdemo.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * 特别要注意第一点，如果要使用@Recover ，@Retryable一定不能有返回值
 * author: yuzq
 * create: 2021-01-10 10:37
 **/
@Service
@Slf4j
public class TaskService {


    @Retryable(value = AuthException.class,maxAttempts = 5,backoff = @Backoff(delay = 3000L, multiplier = 0))
    public void test(Integer a){
        if ((a>2)){
            log.info("要进行重试了...");
            throw new AuthException("重试开始");
        }
        log.info("正常进行...");

    }

    @Recover
    public void recover(AuthException e){
        log.info("recovery{}",e.getMessage());
    }
}
