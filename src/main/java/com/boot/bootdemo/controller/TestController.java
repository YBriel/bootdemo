package com.boot.bootdemo.controller;

import com.boot.bootdemo.entity.money.MyBigDecimalDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("queryMyBigDecimalDemo")
    public MyBigDecimalDemo queryMyBigDecimalDemo(){
        MyBigDecimalDemo myBigDecimalDemo = new MyBigDecimalDemo();
       // myBigDecimalDemo.setMoney(BigDecimal.TEN);
        return myBigDecimalDemo;
    }
}
