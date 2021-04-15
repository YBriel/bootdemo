package com.boot.bootdemo;

import com.alibaba.fastjson.JSONObject;
import com.boot.bootdemo.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.codec.SmileJacksonCodec;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/7/14   20:25
 */
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
public class RedissonLock {

    private RedissonClient redissonClient;


    @Before
    public void before(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://39.106.121.52:6379").setPassword("mz777");
        redissonClient = Redisson.create(config);

    }

    @Test
    public void test() {
        System.out.println("333开始执行");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RLock lock = redissonClient.getLock("anyLock");
        try {
            Future<Boolean> res = lock.tryLockAsync(3, 10, TimeUnit.SECONDS);
            if (res.get()) {
                RBucket<String> locktest = redissonClient.getBucket("locktest", StringCodec.INSTANCE);
                System.out.println(locktest);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("333执行结束");
        }

/*        new Thread(() -> {
            System.out.println("222开始执行");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RLock lock = redissonClient.getLock("anyLock");
            try {
//                lock.lockAsync();
//                lock.lockAsync(10, TimeUnit.SECONDS);
                Future<Boolean> res = lock.tryLockAsync(3, 10, TimeUnit.SECONDS);
                if (res.get()) {
                    RBucket<String> locktest = redissonClient.getBucket("locktest", StringCodec.INSTANCE);
                    System.out.println(locktest);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                System.out.println("222执行结束");
                lock.unlock();
            }
        }, "222").start();*/
    }

    @Test
    public void test2(){
        //redissonClient.getScoredSortedSet(DistributeConstants.redisPrefix.INSTANT_CAR_DISTRIBUTE_ORDER).add(100, json);
        redissonClient.getScoredSortedSet("dsad").remove("sdsd");
    }

    @Test
    public void testList(){
/*        RList<String> list = redissonClient.getList("qn:pickup:order" , StringCodec.INSTANCE);
        List<String> list1 = list.readAll();

        list.removeIf(o->o.contains("1"));

        System.out.println(list1.size());*/
        RMap<String, Student> map = redissonClient.getMap("qn:pickup:order1", JsonJacksonCodec.INSTANCE);
        map.put("test",new Student("tom",12));
        map.put("test1",new Student("tom2",112));

        Student  student = map.get("test");
        Student student1 = map.get("test1");
       // map.remove("test");
        System.out.println("还好");

//        boolean add = list.add("tes1");
//        boolean ad1d = list.add("tes2");



    }
}
