package com.boot.bootdemo.controller;

import com.boot.bootdemo.util.SumTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2021-03-05 21:46
 **/
@RestController
@Slf4j
@RequestMapping("gps")
public class UploadGpsTest {


    @RequestMapping("upload")
    public SumTimeUtil.DriverTime driverTime(Long userId, Long timeStamp){
         SumTimeUtil sumTimeUtil=new SumTimeUtil();
         return sumTimeUtil.driverTimeCal(userId,timeStamp);
    }

    @RequestMapping("getDriver")
    public SumTimeUtil.DriverTime driverTime(Long id){
        return SumTimeUtil.map.get(id);
    }
}
