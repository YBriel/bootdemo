package com.boot.bootdemo;

/**
 * author: yuzq
 * create: 2020-08-14 18:07
 **/
public class TestStatic {
    private static String aa="aaa";



    public TestStatic() {

        System.out.println("innerStatic无参构造...");
    }


    public static void say(){
        System.out.println("hello");
    }

     static class innerStatic{

        public innerStatic() {
            System.out.println("innerStatic无参构造...");
        }

        public static void say(){
            System.out.println("hello");
        }
    }

     class inner{
         public inner() {
             System.out.println("inner无参构造...");
         }

         public  void say(){
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        TestStatic testStatic=new TestStatic();
    }
}
