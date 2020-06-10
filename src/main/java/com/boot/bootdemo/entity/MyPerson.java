package com.boot.bootdemo.entity;

import lombok.Data;

/**
 * author: yuzq
 * create: 2020-06-10 09:39
 **/
@Data
public class MyPerson implements Comparable<Person> {


    private String name;

    private Integer age;
    @Override
    public int compareTo(Person o) {
        return this.age-o.getAge();
    }
}
