package com.boot.bootdemo.thread;

class ReorderExample {
  int x = 0;
  boolean flag = false;
  public void writer() {
    x = 42;    //1
    flag = true;    //2
  }
  public void reader() {
    if (flag) { //3
      System.out.println(x);    //4
    }
  }

  public static void main(String[] args) {
    ReorderExample reorderExample=new ReorderExample();
    reorderExample.writer();
    reorderExample.reader();
  }
}