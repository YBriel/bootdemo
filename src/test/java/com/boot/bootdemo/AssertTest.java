package com.boot.bootdemo;


import org.springframework.util.Assert;

/**
 * author: yuzq
 * create: 2020-06-04 15:43
 **/
public class AssertTest {

    public static void main(String[] args) {

        try {
            int i=1/0;
        }catch (Exception e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println(stackTraceElement.getClassName());
                System.out.println(stackTraceElement.getFileName());
                System.out.println(stackTraceElement.getLineNumber());
                System.out.println(stackTraceElement.getMethodName());
            }
            e.printStackTrace();
        }


        Integer a=11;
        Assert.notNull(a,"不能为空啊");
        System.out.println(a);
    }
}
