package com.boot.bootdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.List;

/**
 * author: yuzq
 * create: 2020-06-04 15:25
 **/
@Data
@TableName("student")
public class MyStudentEntity extends Model<MyStudentEntity> {

    private int id;

    private String name;

    private int age;


    public MyStudentEntity queryStudentById(int id){
       return selectById(id);
    }

    public List<MyStudentEntity> queryStudentById(){
        return selectAll();
    }

}
