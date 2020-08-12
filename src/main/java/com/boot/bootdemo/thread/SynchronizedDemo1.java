package com.boot.bootdemo.thread;

/**
 * author: yuzq
 * create: 2020-08-12 15:34
 **/
public class SynchronizedDemo1 {


    /**
     * 同步静态方法
     */
    public synchronized static void accessResource(){
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    }

    /**
     * 同步方法
     */
    public synchronized  void accessResource1(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步代码块
     * 在 Java 中，每个对象都会有一个 monitor 对象，监视器。
     * 1)某一线程占有这个对象的时候，先monitor 的计数器是不是0，如果是0还没有线程占有，这个时候线程占有这个对象，并且对这个对象的monitor+1；如果不为0，表示这个线程已经被其他线程占有，这个线程等待。当线程释放占有权的时候，monitor-1；
     * 2)同一线程可以对同一对象进行多次加锁，+1，+1，重入性
     */
    public  void accessResource2(){

        Integer i=10;
        synchronized (i){
            System.out.println("11");  //JIT会优化 不需要加锁
        }
        synchronized(SynchronizedDemo1.class){   // 放类的时候 类加载器加载到方法区时  堆生成一个对象
            try {
                Thread.sleep(3000);
                //Thread.currentThread().getClass()
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        SynchronizedDemo1 demo1=new SynchronizedDemo1();
        new Thread(SynchronizedDemo1::accessResource).start();
    }
}
