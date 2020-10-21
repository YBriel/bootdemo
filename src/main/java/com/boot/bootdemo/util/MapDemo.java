package com.boot.bootdemo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * author: yuzq
 * create: 2020-10-21 13:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapDemo implements Comparable<MapDemo>{

    private String name;
    private Integer age;

    @Override
    public int compareTo(MapDemo o) {
        return this.age-o.getAge();
    }

    public static void main(String[] args) {
        MapDemo person=new MapDemo("南昌",23);
        MapDemo person4=new MapDemo("南昌",11);
        MapDemo person1=new MapDemo("九江",12);


        MapDemo person2=new MapDemo("抚州",42);
        MapDemo person3=new MapDemo("赣州",53);
        MapDemo person5=new MapDemo("赣州",23);

        List<MapDemo> persons = Arrays.asList(person, person1,person2, person3,person4,person5);
        Map<String, List<MapDemo>> collect = persons.stream().collect(Collectors.groupingBy(MapDemo::getName));
        System.out.println(collect);

        LinkedHashMap<String, List<MapDemo>> collect1 = collect.entrySet().stream().sorted((e1, e2) -> e2.getValue().get(0).compareTo(e1.getValue().get(0)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(collect1);


    }
}
