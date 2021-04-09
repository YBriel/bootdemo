package com.boot.bootdemo.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * author: yuzq
 * create: 2021-04-09 16:47
 **/
@Data
public class MyPersonDemo {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "学生列表不能为空")
    @Valid
    private List<MyPersonDemo1> students;
}
