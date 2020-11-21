package com.boot.bootdemo.thread.pool;

import lombok.Data;

/**
 * author: yuzq
 * create: 2020-11-21 15:36
 **/
@Data
public class OuterTest {

    private String name="外部";




    public class InnerTest{
        private String name="内部";

        public InnerTest() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public InnerTest(String name) {
            this.name = name;
        }
    }
}
