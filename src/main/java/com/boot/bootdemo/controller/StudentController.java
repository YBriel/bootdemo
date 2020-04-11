package com.boot.bootdemo.controller;

import com.boot.bootdemo.aspect.SameUrlData;
import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   20:04
 */
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/testStu")
    @SameUrlData
    public void testStu(String name){
        Student student=new Student();
        student.setAge(33);
        student.setName(name);
        boolean save = studentService.save(student);
        System.out.println("最后的"+student.getId());
    }
}
