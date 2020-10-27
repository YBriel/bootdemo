package com.boot.bootdemo.controller;

import com.boot.bootdemo.entity.Hobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * author: yuzq
 * create: 2020-10-24 17:14
 **/
@RestController
@RequestMapping("hobby")
public class SqlSessionController {

    @Autowired
    private Hobby hobby;

    @RequestMapping("test")
    public void test(){
        hobby.getMyHobby();
    }

    @RequestMapping("test2")
    public void test1(){
        hobby.test();
    }

    @RequestMapping("test3")
    public void test3() throws SQLException {
        hobby.test1();
    }
}
