package com.boot.bootdemo;

import com.boot.bootdemo.entity.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author: yuzq
 * create: 2020-06-10 09:32
 **/
public class ComparableTest {


    public static void main(String[] args) {
        List<String> strings= Arrays.asList("222","23232","sdasd");
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        strings.sort(((o1, o2) -> o1.length()-o2.length()));
        strings.sort((Comparator.comparingInt(String::length)));


        List<Person> people=new ArrayList<>();
        Person p=new Person("tom",22);
        Person p1=new Person("jerry",21);
        people.add(p);
        people.add(p1);
        people.sort(Comparator.comparingInt(Person::getAge));


        Map<String,Person> personMap=new LinkedHashMap<>();
        personMap.put("ttt",new Person("tt",23));
        personMap.put("yyy",new Person("yy",32));

        Map<String, Person> collect = personMap.entrySet().stream().sorted(Map.Entry.comparingByValue((Comparator.comparingInt(Person::getAge)))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k));
        Map<Map.Entry<String, Person>, Map.Entry<String, Person>> collect1 = personMap.entrySet().stream().sorted(Map.Entry.comparingByValue((Comparator.comparingInt(Person::getAge)))).collect(Collectors.toMap(k -> k, v -> v, (k, v) -> k));
        LinkedHashMap<Map.Entry<String, Person>, Map.Entry<String, Person>> collect2 = personMap.entrySet().stream().sorted(Map.Entry.comparingByValue((Comparator.comparingInt(Person::getAge)))).collect(Collectors.toMap(k -> k, v -> v, (v1, v2) -> v1, LinkedHashMap::new));
        LinkedHashMap<String, Person> collect3 = personMap.entrySet().stream().sorted(Map.Entry.comparingByValue((Comparator.comparingInt(Person::getAge)))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

    }
}
