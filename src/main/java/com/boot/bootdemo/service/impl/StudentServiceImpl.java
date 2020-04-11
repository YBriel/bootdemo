package com.boot.bootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.mapper.StudentMapper;
import com.boot.bootdemo.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   20:01
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
