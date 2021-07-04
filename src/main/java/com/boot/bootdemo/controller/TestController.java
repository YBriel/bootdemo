package com.boot.bootdemo.controller;

import com.boot.bootdemo.entity.money.MyBigDecimalDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("queryMyBigDecimalDemo")
    public MyBigDecimalDemo queryMyBigDecimalDemo(@RequestParam(value = "name",required = false) String name,
                                                  @RequestParam(value = "age",required = false) Integer age,
                                                  @RequestParam(value = "money",required = false) BigDecimal money){
        MyBigDecimalDemo myBigDecimalDemo = new MyBigDecimalDemo();
        myBigDecimalDemo.setMoney(money);
        myBigDecimalDemo.setAge(age);
        myBigDecimalDemo.setName(name);
       // myBigDecimalDemo.setMoney(BigDecimal.TEN);
        return myBigDecimalDemo;
    }
}
