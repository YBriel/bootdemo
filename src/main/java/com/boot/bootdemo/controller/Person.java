package com.boot.bootdemo.controller;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/20   15:09
 */
public class Person {

    private int id;
    private String name;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Person() {
    }

    public static void main(String[] args) {
        Person p=new Person(1,"tom","男");
        Person p2=new Person(2,"tina","女");
        Person p3=new Person(3,"jerry","男");
        Person p4=new Person(4,"nina","女");

        List<Person> personList=new ArrayList<>();
        personList.add(p);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        String s = JSONObject.toJSONString(personList);
        System.out.println(s);
    }
}
