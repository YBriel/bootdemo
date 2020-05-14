package com.boot.bootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.bootdemo.aspect.SameUrlData;
import com.boot.bootdemo.entity.Student;
import com.boot.bootdemo.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "id",required = false)String id,@RequestParam(value = "name",required = true)String name){
        System.out.println("请求进来了:"+id+name);
        return name;
    }

    @RequestMapping("/testLambda")
    public List<Student> testLambda(){
        List<Student> list1 = studentService.list();
        List<Student> list = studentService.list(new LambdaQueryWrapper<>(new Student()).select(Student::getId, Student::getName));
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
        return list;
    }

    @RequestMapping("/deleteStu")
    public boolean deleteStu(int id){
        List<Student> list = studentService.list();
        Student byId = studentService.getById(id);
        QueryWrapper<Student> studentQueryWrapper=new QueryWrapper<>();
        studentQueryWrapper.eq("id",id);
        Student one = studentService.getOne(studentQueryWrapper);
        return studentService.remove(studentQueryWrapper);
        //List<Student> list1 = studentService.list(new LambdaQueryWrapper<>(new Student()).);
    }
}
