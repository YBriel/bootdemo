package com.boot.bootdemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * author: yuzq
 * create: 2021-01-10 10:38
 **/
@Data
public class TaskEntity {

    private Long id;
    private String jobName;
    private String description;
    private String cronExpression;
    private String beanClass;
    private String jobStatus;
    private String jobGroup;
    private String createUser;
    private String updateUser;
    private Date createTime;
    private Date updateTime;
}
