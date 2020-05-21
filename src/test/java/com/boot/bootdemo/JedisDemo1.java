package com.boot.bootdemo;

import redis.clients.jedis.Jedis;

/**
 * author: yuzq
 * create: 2020-05-21 10:43
 **/
public class JedisDemo1 {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("39.106.121.52");
       jedis.auth("mz666");
     /*    jedis.set("people:man","tom");
        jedis.set("people:woman","tim");
        jedis.set("people:child","jerry");
        jedis.set("people:adult","look");*/
        jedis.set("people:adult:woman","peach");
        System.out.println(jedis.get("people:child"));
        jedis.close();
    }
}
