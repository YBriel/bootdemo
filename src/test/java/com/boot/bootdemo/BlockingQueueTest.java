package com.boot.bootdemo;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * author: yuzq
 * create: 2020-07-30 10:36
 **/
public class BlockingQueueTest {

    public static void main(String[] args) {

        LinkedBlockingQueue<String> strings=new LinkedBlockingQueue<>(5);
        Scanner scanner=new Scanner(System.in);
        while (!scanner.next().contains(",")){
            strings.add(scanner.nextLine());
            System.out.println(strings.size());
            if(strings.size()>=5){
                strings.clear();
                System.out.println(strings.size());
            }
        }
        System.out.println("结束运行");
    }
}
