package com.boot.bootdemo.validate;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

/**
 * author: yuzq
 * create: 2021-02-24 21:03
 **/
@RestController
@RequestMapping("validate")
@Slf4j
public class ValidateController {

    @RequestMapping("test2")
    public String test2(@Validated({MicroBusinessGroup.class}) ValidateEntity validateEntity){
        log.info(JSON.toJSONString(validateEntity));
        return "2";
    }

    @RequestMapping("test3")
    public String test3(@Validated({CompanyGroup.class, Default.class}) ValidateEntity validateEntity){
        log.info(JSON.toJSONString(validateEntity));
        return "3";
    }

    @RequestMapping("test4")
    public String test4(@Validated({IndividualGroup.class}) ValidateEntity validateEntity){
        log.info(JSON.toJSONString(validateEntity));
        return "4";
    }
}
