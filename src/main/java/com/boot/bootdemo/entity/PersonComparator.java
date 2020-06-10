package com.boot.bootdemo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * author: yuzq
 * create: 2020-06-10 09:40
 **/
public class PersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        return o2.getAge()-o1.getAge();
    }

    public static void main(String[] args) {
        List<Person> people1 = Arrays.asList(new Person("tt", 2), new Person("232", 22));
        people1.sort(new PersonComparator());
        System.out.println(people1);
    }
}
