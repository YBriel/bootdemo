package com.boot.bootdemo;

import com.alibaba.fastjson.JSONObject;
import com.boot.bootdemo.entity.Student;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/13   22:18
 */
/*@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)*/
//@RunWith(JUnit4.class)
public class RedisTest {

/*
    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void testAdd(){
        RBucket<String> test = redissonClient.getBucket("test",StringCodec.INSTANCE);
        RBucket<String> bbb = redissonClient.getBucket("aaa", StringCodec.INSTANCE);
        bbb.set("ttt");
        RBucket<String> ccc = redissonClient.getBucket("ccc");
        bbb.set("ccc");
        String o = test.get();
        System.out.println(o);
    }
*/

    @Test
    public void testdemo1(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://39.106.121.52:6379");
        RedissonClient redisson = Redisson.create(config);
        RGeo<String> geo2 = redisson.getGeo("geo2", StringCodec.INSTANCE);
        geo2.add(115.861166,28.742931,"shuanggang");
       // geo.add(115.886572,28.75008,"baishuihu"));
       // geo.add(115.85224,28.684065,"ditie"));
        geo2.add(115.855556,28.743952,"caida");
        geo2.add(115.877357,28.742823,"ligong");
        geo2.add(115.817103,28.739738,"linkeyuan");

       // geo.add(new GeoEntry(115.785549,28.650552,"yongyou"));
     /*   geo.add(new GeoEntry(115.925539,28.634658,"hongdu"));
        geo.add(new GeoEntry(115.838936,28.741351,"nantian"));*/
        geo2.add(115.888515,28.745457,"posit");
        geo2.add(115.812984,28.744855,"far");
        Map<String, GeoPosition> stringGeoPositionMap = geo2.radiusWithPosition(115.85224,28.684065, 3, GeoUnit.KILOMETERS, 5);
        Map<String, GeoPosition> stringGeoPositionMap1 = geo2.radiusWithPosition(115.85224,28.684065, 5, GeoUnit.KILOMETERS, 5);
        Map<String, GeoPosition> stringGeoPositionMap2= geo2.radiusWithPosition(115.888515,28.745457, 9, GeoUnit.KILOMETERS,GeoOrder.ASC, 3);
        Map<String, GeoPosition> stringGeoPositionMap3= geo2.radiusWithPosition(115.888515,28.745457, 9, GeoUnit.KILOMETERS,GeoOrder.DESC, 3);
        //Map<String, GeoPosition> stringGeoPositionMap3= geo.radiusW(115.85224,28.684065, 9, GeoUnit.KILOMETERS, 5);
       stringGeoPositionMap2.forEach((k,v)-> System.out.println("key : " + k + "; value : " + v.getLatitude()));
       stringGeoPositionMap3.forEach((k,v)-> System.out.println("key : " + k + "; value : " + v.getLatitude()));

        stringGeoPositionMap2.forEach((k,v)-> System.out.println(k+"---"+"距离是："+geo2.dist("posit",k,GeoUnit.METERS)));
       // stringGeoPositionMap2.entrySet().stream().forEach((k,v)-> System.out.println(geo.dist()));
        //geo.radiusStoreSortedTo()
        redisson.shutdown();
    }

    @Test
    public void testdemo2(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://39.106.121.52:6379");
        RedissonClient redisson = Redisson.create(config);
        RGeo<String> geo = redisson.getGeo("test1");
        geo.add(new GeoEntry(115.861166,28.742931,"shuanggang"));
        geo.add(new GeoEntry(115.886572,28.75008,"baishuihu"));
        geo.add(new GeoEntry(115.85224,28.684065,"ditie"));
        geo.add(new GeoEntry(115.785549,28.650552,"yongyou"));
        geo.add(new GeoEntry(115.925539,28.634658,"hongdu"));
        geo.add(new GeoEntry(115.838936,28.741351,"nantian"));
        geo.add(new GeoEntry(115.913409,28.855678,"test"));
        Double distance = geo.dist("shuanggang", "baishuihu", GeoUnit.METERS);
        System.out.println(distance);
        geo.hashAsync("Palermo", "Catania");
        Map<String, GeoPosition> positions = geo.pos("test2", "Palermo", "test3", "Catania", "test1");
        List<String> cities = geo.radius(15, 37, 200, GeoUnit.KILOMETERS);
        Map<String, GeoPosition> citiesWithPositions = geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS);
        redisson.shutdown();
    }


    @Test
    public void testdemo3(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://39.106.121.52:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RBucket<String> bucket = redissonClient.getBucket("upload-gps-360100" , StringCodec.INSTANCE);
        Student region;
        String regionStr = bucket.get();
        if(StringUtils.isEmpty(regionStr)){
            region  = new Student(111,"tim",222);
            bucket.set(JSONObject.toJSONString(region));
        }else {
            region = JSONObject.parseObject(regionStr, Student.class);
        }
        System.out.println(region);
        redissonClient.shutdown();
    }
}
