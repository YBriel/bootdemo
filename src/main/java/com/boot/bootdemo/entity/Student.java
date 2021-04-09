package com.boot.bootdemo.entity;

import com.boot.bootdemo.aspect.Dict;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   19:58 extends BaseEntity<Student>
 */

@Data
public class Student{

    //@Dict(dictName = "stu" ,dictKey = "id")
    private int id;

    @Dict(dictName = "stu" ,dictKey = "name")
    @NotBlank(message = "学生1名字不能为空")
    private String name;

    @Dict(dictName = "stu" ,dictKey = "age")
    private int age;

    public Student() {

        //System.out.println("这是学生的构造器打印出来的！");
    }

    /*    private String nameStr;

    private String ageStr;*/

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int a,String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Student student=new Student();
        //student.selectById()
    }
    // private String ageStr;

}
