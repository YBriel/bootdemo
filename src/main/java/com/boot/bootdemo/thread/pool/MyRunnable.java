package com.boot.bootdemo.thread.pool;

import lombok.Data;

/**
 * author: yuzq
 * create: 2020-11-21 15:19
 **/
@Data
public class MyRunnable {



    private class MyRunnableDemo  implements Runnable{

        private Integer id;

        public MyRunnableDemo() {
        }

        public MyRunnableDemo(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(id);
        }
    }
}
