package com.boot.bootdemo;

import redis.clients.jedis.Jedis;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/20   7:08
 */
public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("39.106.121.52");
        jedis.auth("mz666");
   /*     for (int i = 100; i >=1; i--) {
            jedis.lpush("demo",i+"");
        }*/
/*        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String demo = jedis.lpop("demo");
                System.out.println(Thread.currentThread().getName()+"---------"+demo);
            }, String.valueOf(i)).start();
        }*/
        for (int i = 0; i < 40; i++) {
            String demo = jedis.lpop("demo");
            System.out.println(Thread.currentThread().getName()+"---------"+demo);
        }
        //jedis.lo
        System.out.println(jedis.ping());
    }
}
