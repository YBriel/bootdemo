package com.boot.bootdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: yuzq
 * create: 2020-09-09 12:20
 **/
public class FileTest {

    public static void main(String[] args) throws IOException {
        //新建一个字符缓冲输入流对象，将基本字符输入流作为其参数，将e.txt文件作为基本字符输入流参数，其为需要读取的文本文件
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/order.txt"));
        //定义字符串变量str
        String str;
        //新建一个ArrayList集合，用其父类给ls集合定义数据类型
        List<String> ls = new ArrayList<String>();
        //将br输入流对象赋值给字符串变量，判断其是否为空
        int a=0;
        while((str=br.readLine())!=null) {
            a++;
            //若不为空，则将字符串str添加至集合ls中
            ls.add(str);
        }
        //输出集合
        System.out.println(ls);
        //关闭字符缓冲输入流
        System.out.println(a);
        br.close();
    }
}
