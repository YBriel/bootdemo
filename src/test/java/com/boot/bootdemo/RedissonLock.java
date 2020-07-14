package com.boot.bootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/7/14   20:25
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedissonLock {

    @Autowired
    private RedissonClient redissonClient;

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

}
