package com.boot.bootdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/20   7:08
 */
public class JedisTest {

    public static void main(String[] args) {
        JedisPool jedisPool=new JedisPool();
        Jedis jedis=new Jedis("39.106.121.52");
        jedis.auth("mz666");
        for (int i = 100; i >=1; i--) {
            jedis.lpush("demo",i+"");
        }
/*        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String demo = jedis.lpop("demo");
                System.out.println(Thread.currentThread().getName()+"---------"+demo);

            }, String.valueOf(i)).start();
        }*/
/*        for (int i = 40; i < 100; i++) {
           // String demo = jedis.lpop("demo");
            jedis.lpush("demolist","no"+i);
          //  System.out.println(Thread.currentThread().getName()+"---------"+demo);
        }*/
        //jedis.lo
        System.out.println(jedis.ping());

       /* List<Integer> objects = Collections.synchronizedList(new ArrayList<Integer>());
        objects.add(1);
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                String demolist = jedisPool.getResource().lpop("demolist");
                System.out.println(demolist);
                Integer integer = objects.get(0);
                objects.remove(0);
                objects.add(integer++);
            },"").start();
        }
        System.out.println(objects.get(0));*/
    }


}
