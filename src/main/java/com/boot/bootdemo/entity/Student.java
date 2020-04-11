package com.boot.bootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   19:58
 */
@Data
public class Student {

    @TableId(type = IdType.AUTO)
    private int id;

    private String name;

    private int age;
}
