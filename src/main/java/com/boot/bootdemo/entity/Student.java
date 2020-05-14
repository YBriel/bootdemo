package com.boot.bootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.boot.bootdemo.aspect.Dict;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   19:58
 */
@Data
@Dict
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Dict(dictName = "stu" ,dictKey = "id")
    private int id;

    @Dict(dictName = "stu" ,dictKey = "name")
    private String name;

    @Dict(dictName = "stu" ,dictKey = "age")
    private int age;
    @TableField(value = "createTime")
    private Date createTime;
    @TableField(value = "updateTime")
    private Date updateTime;
    private int state;



   // private String ageStr;

}
