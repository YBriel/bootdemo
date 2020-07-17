package com.boot.bootdemo.controller;

import com.boot.bootdemo.entity.InnerVo;
import com.boot.bootdemo.entity.MyStudentEntity;
import com.boot.bootdemo.entity.OuterVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author： yuzq
 * Description: RequestResponseBodyMethodProcessor
 * Date: 2020/5/20   22:44
 */
@RestController
public class MyStudentController {

    @RequestMapping("/student")
    public MyStudent student(){
        return new MyStudent();
    }

    @RequestMapping("/myStudentEntity")
    public MyStudentEntity student(Integer id){
        MyStudentEntity myStudentEntity=new MyStudentEntity();
      return   myStudentEntity.queryStudentById(id);
    }

    @RequestMapping("/myStudentEntityList")
    public List<MyStudentEntity> student1(){
        MyStudentEntity myStudentEntity=new MyStudentEntity();
        return   myStudentEntity.queryStudentById();
    }
    @PostMapping("/testStr1")
    public void testStr(@RequestBody OuterVo outerVo){
        System.out.println(outerVo);
    }
}
