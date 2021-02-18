package com.boot.bootdemo;

import com.alibaba.fastjson.JSONObject;
import com.boot.bootdemo.entity.Student;
import io.lettuce.core.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/5/13   22:18
 */
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(JUnit4.class)
public class RedisTest {

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
       // config.useSingleServer().setAddress("redis://39.106.121.52:6379");
        config.useSingleServer().setAddress("redis://192.168.0.239:6379").setPassword("yzcxdevredis");
        RedissonClient redisson = Redisson.create(config);
        RGeo<String> geo = redisson.getGeo("test111");
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

    @Test
    public void test5(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.0.239:6379").setPassword("yzcxdevredis");
        RedissonClient redisson = Redisson.create(config);
        RGeo<String> geo = redisson.getGeo("myGeo");
        geo.expire(10,TimeUnit.HOURS);
        GeoEntry entry = new GeoEntry(13.361389, 38.115556, "Palermo");
        geo.add(entry);
        geo.add(15.087269, 37.502669, "Catania");

        Double dist = geo.dist("Palermo", "Catania", GeoUnit.METERS);

        Map<String, GeoPosition> pos = geo.pos("Palermo", "Catania");

        List<String> cities = geo.radius(15, 37, 200, GeoUnit.KILOMETERS);
        List<String> allNearCities = geo.radius("Palermo", 10, GeoUnit.KILOMETERS);

        Map<String, Double> citiesWithDistance = geo.radiusWithDistance(15, 37, 200, GeoUnit.KILOMETERS);
        Map<String, Double> allNearCitiesDistance = geo.radiusWithDistance("Palermo", 10, GeoUnit.KILOMETERS);

        Map<String, GeoPosition> citiesWithPosition = geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS);
        Map<String, GeoPosition> allNearCitiesPosition = geo.radiusWithPosition("Palermo", 10, GeoUnit.KILOMETERS);

        redisson.shutdown();
        /*RGeo<String> geo = redisson.getGeo("test-geo1");
        geo.add(new GeoEntry(115.861166,28.742931,"1281451888327397376:1605841157228:0:1"));
        geo.add(new GeoEntry(115.886572,28.75008,"1268107027469701120:1605841156501:0:1"));
        geo.add(new GeoEntry(115.85224,28.684065,"1309010672486584320:1605841149553:0:1"));
        geo.add(new GeoEntry(115.785549,28.650552,"1288015257649942528:1605841156194:0:1"));
        geo.add(new GeoEntry(115.925539,28.634658,"1280831933969993728:1605841148223:0:1"));
        geo.add(new GeoEntry(115.838936,28.741351,"1308968893603254272:1605841155201:0:1"));
        geo.add(new GeoEntry(115.913409,28.855678,"1278518162245160960:1605841156502:0:1"));
        Collection<String> strings = geo.readAll();

        long l = System.currentTimeMillis();
        // List<String> collect = strings.stream().filter(o -> o.split(":")[2].equals("0") && Long.parseLong(o.split(":")[1]) > l).map(o -> o.split(":")[0]).collect(Collectors.toList());
        // List<String> collect = strings.stream().filter(o -> o.split(":")[2].equals("0")).map(o -> o.split(":")[0]).collect(Collectors.toList());
        List<Long> collect = strings.stream().filter(o -> o.split(":")[2].equals("0")).map(o -> Long.parseLong(o.split(":")[0])).collect(Collectors.toList());
        List<String> collect3 = strings.stream().filter(o -> o.split(":")[2].equals("0")).map(o -> o.split(":")[0]).collect(Collectors.toList());
        //List<String> collect4 = strings.stream().filter(o -> o.split(":")[2].equals("0")).collect(Collectors.toList());
        List<Long> collect2 = strings.stream().filter(o -> o.split(":")[2].equals("0")).map(o -> Long.parseLong(o.split(":")[0])).distinct().collect(Collectors.toList());
        List<String> collect1 = strings.stream().filter(o -> o.split(":")[2].equals("1") || o.split(":")[3].equals("1")).collect(Collectors.toList());

        String[] strings1 = strings.stream().filter(o -> o.split(":")[2].equals("0")).toArray(String[]::new);
        RGeo<String> geo1 = redisson.getGeo("test-geo1");

      //  Map<String, GeoPosition> pos = geo.pos(strings1[0]);
        Map<String, GeoPosition> pos2 = geo1.pos(strings1[0]);
        Map<String, GeoPosition> pos1 = geo.pos(strings1);
        Map<String, GeoPosition> pos3 = geo1.pos(strings1);


        System.out.println(collect);
        System.out.println(collect2);
        System.out.println(strings.size());
        redisson.shutdown();*/
    }

    @Test
    public void testdemo4(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://39.106.121.52:6379");


        RedissonClient redisson = Redisson.create(config);
        RGeo<String> geo = redisson.getGeo("test1",StringCodec.INSTANCE);
      /*  geo.add(new GeoEntry(115.861166,28.742931,"shuanggang"));
        geo.add(new GeoEntry(115.886572,28.75008,"baishuihu"));
        geo.add(new GeoEntry(115.85224,28.684065,"ditie"));
        geo.add(new GeoEntry(115.785549,28.650552,"yongyou"));
        geo.add(new GeoEntry(115.925539,28.634658,"hongdu"));
        geo.add(new GeoEntry(115.838936,28.741351,"nantian"));
        geo.add(new GeoEntry(115.913409,28.855678,"test"));*/
        long l = System.currentTimeMillis();
        RList<Object> geoList = redisson.getList("geoList",StringCodec.INSTANCE);
        RMap<String, String> geoMap = redisson.getMap("geoMap", StringCodec.INSTANCE);

        geo.add(new GeoEntry(111.838936,28.741351,"nantian"+l));
        geoMap.put("nantian","nantian"+l);
        //geoList.add("nantian"+l+10);
        geo.add(new GeoEntry(115.861166,28.742931,"shuanggang"+l));
        geoMap.put("shuanggang","shuanggang"+l);
        //geoList.add("shuanggang"+l+10);
        geo.add(new GeoEntry(115.886572,28.75008,"baishuihu"+l));
        geoMap.put("baishuihu","baishuihu"+l);

        // geoList.add("baishuihu"+l+10);
        geo.add(new GeoEntry(115.85224,28.684065,"ditie"+l));
        geoMap.put("ditie","ditie"+l);
        //  geoList.add("ditie"+l+10);
        geo.add(new GeoEntry(115.785549,28.650552,"yongyou"+l));
        geoMap.put("ditie","ditie"+l);
        //  geoList.add("yongyou"+l+10);

        System.out.println(geo.size());
/*        try {
            Thread.sleep(3000);
            geo.remove("yongyou");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(geo.size());
      //  boolean expire = geo.expire(20, TimeUnit.SECONDS);
       // System.out.println(expire);
       /* boolean yongyou = geo.remove("ditie");
        System.out.println(yongyou);*/
        redisson.shutdown();
    }

}
