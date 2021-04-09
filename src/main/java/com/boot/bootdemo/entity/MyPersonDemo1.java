package com.boot.bootdemo.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * author: yuzq
 * create: 2021-04-09 16:48
 **/
@Data
public class MyPersonDemo1 {

    @NotBlank(message = "爱好不能为空")
    private String hobby;

    @NotEmpty
    @Valid
    private List<MyPersonDemo2> demo2s;
}
