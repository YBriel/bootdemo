package com.boot.bootdemo.controller;

import com.boot.bootdemo.aspect.MyDateFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * author: yuzq
 * create: 2021-02-01 11:08
 **/
@RestController
@RequestMapping("date")
public class DateTimeController {


    @RequestMapping("testDate")
    public Date testDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        return date;
    }

    @RequestMapping("testDateLa")
    public Date testDateLa(@MyDateFormat Date date){
        return date;
    }

    @RequestMapping("testDateTime")
    public Date testDateTime(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date){
        return date;
    }

    @RequestMapping("testTime")
    public Date testTime(@DateTimeFormat(iso = DateTimeFormat.ISO.TIME) Date date){
        return date;
    }
}
