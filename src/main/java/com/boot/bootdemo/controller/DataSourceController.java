package com.boot.bootdemo.controller;

import com.boot.bootdemo.service.MultiDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: yuzq
 * create: 2021-01-20 10:13
 **/
@RestController
public class DataSourceController {

    @Autowired
    private MultiDatasource datasource;

    @RequestMapping("query")
    public List query(Long id){
        return datasource.queryMain(id);
    }

    @RequestMapping("query1")
    public List query1(Long id){
        return datasource.queryMain1(id);
    }
}
