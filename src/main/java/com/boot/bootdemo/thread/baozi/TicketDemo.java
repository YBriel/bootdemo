package com.boot.bootdemo.thread.baozi;

/**
 * author: yuzq
 * create: 2021-01-22 15:11
 **/
public class TicketDemo extends Thread {

    private static int a=100;

    public TicketDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("第一"+this.getName());
        while (true){
            System.out.println("第二"+this.getName());
            synchronized (TicketDemo.class){
                if(a>0){
                    System.out.println(this.getName()+"剩余票--"+(a--));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    return;
                }
            }


        }
    }

     public static void main(String[] args) {
         TicketDemo ticket1 = new TicketDemo("ticket1");
         TicketDemo ticket2 = new TicketDemo("ticket2");
         TicketDemo ticket3 = new TicketDemo("ticket3");
         TicketDemo ticket4 = new TicketDemo("ticket4");
            ticket1.start();
            ticket2.start();
            ticket3.start();
            ticket4.start();
        }
}
