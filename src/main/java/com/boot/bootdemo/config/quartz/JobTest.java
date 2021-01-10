package com.boot.bootdemo.config.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * author: yuzq
 * create: 2021-01-10 10:47
 **/
@Component
@Slf4j
public class JobTest {

    public void test(){
      log.info("测试任务开始{}",new Date());
    }
}
