package com.boot.bootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.bootdemo.entity.Student;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   20:00
 */
public interface StudentService extends IService<Student> {

    Student queryStu(String name,Integer age);
}
