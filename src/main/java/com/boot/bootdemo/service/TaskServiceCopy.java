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
@Slf4j
public class TaskServiceCopy {


    @Retryable(value = AuthException.class,maxAttempts = 5,backoff = @Backoff(delay = 3000L, multiplier = 0))
    public static void test(Integer a){
        if ((a>2)){
            log.info("要进行重试了...");
            throw new AuthException("重试开始");
        }
        log.info("正常进行...");
    }

    /**
     * Recover: 用于方法。用于@Retryable失败时的“兜底”处理方法。 @Recover注释的方法必须要与@Retryable注解的方法“签名”保持一致，第一入参为要重试的异常，其他参数与@Retryable保持一致，返回值也要一样，否则无法执行！
     * 失败后需要做的事
     * @param e 异常
     */
    @Recover
    public void recover(AuthException e){
        log.info("recovery111{}",e.getMessage());
    }
}
