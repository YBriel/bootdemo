package com.boot.bootdemo.entity;

import com.boot.bootdemo.aspect.Dict;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   19:58
 */

@Data
@NoArgsConstructor
public class Student extends BaseEntity<Student>{

    //@Dict(dictName = "stu" ,dictKey = "id")
    private int id;

    @Dict(dictName = "stu" ,dictKey = "name")
    private String name;

    @Dict(dictName = "stu" ,dictKey = "age")
    private int age;

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
