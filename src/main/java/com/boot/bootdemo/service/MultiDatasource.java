package com.boot.bootdemo.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author: yuzq
 * create: 2021-01-20 10:09
 **/
@Component
@DS("slave1")
public class MultiDatasource {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @DS("slave1")
    public List queryMain(Long id){
        return jdbcTemplate.queryForList("select driver_name from driver where id="+id);
    }

    @DS("slave")
    public List queryMain1(Long id){
        return jdbcTemplate.queryForList("select driver_name from driver where id="+id);
    }
}
