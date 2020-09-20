package com.boot.bootdemo.thread.netease;

/**
 * author: yuzq
 * create: 2020-09-06 17:03
 **/
public class MyAQS {

    //acquire ,acquireShared :定义了资源争用的逻辑，没拿到就等待
    //tryAcquire , tryAcquiredShared 实际执行占用资源的操作，如何判定一个由使用者具体实现
    //release releaseShared  定义释放资源的逻辑 释放之后 通知后续节点进行争抢
    //tryRelease tryReleaseShared 实际执行资源释放的操作，具体的AQS使用者实现


}
