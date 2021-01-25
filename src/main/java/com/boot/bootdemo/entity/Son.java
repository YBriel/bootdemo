package com.boot.bootdemo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/1   10:03
 */
@Data
public class Son extends Parent implements Comparable<Son>{

    private String hobby;

    private String subject;

    static {
        System.out.println("这是静态代码块");
    }
    {
        System.out.println("这不是静态代码块");
    }



    public Son() {
        super();
        System.out.println("这是空的构造函数");
    }

    public Son(String name, int age, String hobby) {

        this.hobby = hobby;
        System.out.println("这是有参的构造函数");
    }

    public static void main(String[] args) {

/*        Son s=new Son("1",22,"23");
        Son s1=new Son("2",212,"213");

        List<Son> list =new ArrayList<>();
        list.add(s);
        list.add(s1);
        Collections.sort(list);
        System.out.println(list);*/

       // list.sort();
        Son s=new Son();
      /*  Parent parent=new Son();
        Son s=new Son();
        s=(Son)parent;*/
       // Son parent1= (Son) new Parent();
    }

    @Override
    public int compareTo(Son o) {
        return o.getHobby().length()- this.hobby.length();
    }
}
