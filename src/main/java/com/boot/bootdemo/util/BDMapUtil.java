package com.boot.bootdemo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.boot.bootdemo.config.RR;
import com.boot.bootdemo.config.Result;
import com.boot.bootdemo.entity.bd.*;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * author: yuzq
 * create: 2021-03-18 09:39
 **/

//@Service
@Slf4j
public class
BDMapUtil {


//    @Resource(name = "myrest")
    private static RestTemplate template;
    public static final Map<Integer,String> map=new HashMap<>();

    static {
        template=new RestTemplate();
        map.put(0,"周日");
        map.put(1,"周一");
        map.put(2,"周二");
        map.put(3,"周三");
        map.put(4,"周四");
        map.put(5,"周五");
        map.put(6,"周六");
    }



    public static GeoConvertDto geoConvert(double x, double y){
        Map<String,Object> map=new HashMap<>();
        map.put("coords",x+","+y);
        map.put("from",3);
        map.put("to",5);
        map.put("ak","wLOTOq8GrpYo7Hu70KM96DmdqU40rjr0");
        return template.getForObject("http://api.map.baidu.com/geoconv/v1/?coords={coords}&from={from}&to={to}&ak={ak}",GeoConvertDto.class,map);
    }

    public static BdGeo geoConvertGeo(double x, double y){
        GeoConvertDto forObject = geoConvert(x, y);
        if(forObject!=null && CollectionUtils.isNotEmpty(forObject.getResult())){
            return new BdGeo(forObject.getResult().get(0).getX(),forObject.getResult().get(0).getY());
        }
        return new BdGeo(0.0,0.0);
    }


    /**
     * 经纬度转换
     * @param x 经度
     * @param y 纬度
     * @return 高德经纬度
     */
    public static Result<BdGeo> geoConvertRes(double x, double y){
        GeoConvertDto forObject = geoConvert(x, y);
        if(forObject!=null && CollectionUtils.isNotEmpty(forObject.getResult())){
            return RR.success(new BdGeo(forObject.getResult().get(0).getX(),forObject.getResult().get(0).getY()));
        }
        return RR.fail("经纬度转换失败");
    }

    public static List<BusinessAreaDto> queryBusinessAreaDto(String name, String location, Integer radius, Integer pageNum, Integer pageSize){
        long time=System.currentTimeMillis();
        Map<String,Object> map=new HashMap<>();
        map.put("name",name);
        map.put("location",location);
        map.put("radius",radius==null||radius<=0?3000:radius);
        map.put("page_size",pageSize==null?20:pageSize);
        map.put("page_num",pageNum==null?0:pageNum);
        log.info("百度地图第一步耗时{}",System.currentTimeMillis()-time);
        String res= template.getForObject("http://api.map.baidu.com/place/v2/search?query={name}&location={location}&page_size={page_size}&page_num={page_num}&radius={radius}&output=json&ak=wLOTOq8GrpYo7Hu70KM96DmdqU40rjr0",String.class,map);
        log.info("百度地图第二步耗时{}",System.currentTimeMillis()-time);
        JSONObject jsonObject = JSONObject.parseObject(res);
        log.info("百度地图第三步耗时{}",System.currentTimeMillis()-time);
        JSONArray results = jsonObject.getJSONArray("results");
        log.info("百度地图第四步耗时{}",System.currentTimeMillis()-time);
        if(results!=null){
            log.info("百度地图第五步耗时{}",System.currentTimeMillis()-time);
            List<BusinessAreaDto> businessAreaDtos = results.toJavaList(BusinessAreaDto.class);
            log.info("百度地图第六步耗时{}",System.currentTimeMillis()-time);
            return businessAreaDtos;
        }
        log.error("调用接口出错了{}",res);
        return null;
    }

    public static BdDistance queryDistance(Double x, Double y, Double x1, Double y1) {
        long time=System.currentTimeMillis();
        try {
            log.info("百度地图第一步耗时{}",System.currentTimeMillis()-time);
            String res = template.getForObject("http://api.map.baidu.com/directionlite/v1/driving?origin=" + y + "," + x + "&destination=" + y1 + "," + x1 + "&ak=wLOTOq8GrpYo7Hu70KM96DmdqU40rjr0&tactics=3", String.class);
            log.info("百度地图第二步耗时{}",System.currentTimeMillis()-time);
            JSONObject jsonObject = JSONObject.parseObject(res);
            log.info("百度地图第三步耗时{}",System.currentTimeMillis()-time);
            if (jsonObject != null && jsonObject.getInteger("status") == 0) {
                log.info("百度地图第四步耗时{}",System.currentTimeMillis()-time);
                JSONObject result = jsonObject.getJSONObject("result");
                log.info("百度地图第五步耗时{}",System.currentTimeMillis()-time);
                JSONArray routes = result.getJSONArray("routes");
                log.info("百度地图第六步耗时{}",System.currentTimeMillis()-time);
                if (routes.size() > 0) {
                    log.info("百度地图第七步耗时{}",System.currentTimeMillis()-time);
                    Integer distance = routes.getJSONObject(0).getInteger("distance");
                    log.info("百度地图第八步耗时{}",System.currentTimeMillis()-time);
                    Integer duration = routes.getJSONObject(0).getInteger("duration");
                    log.info("百度地图第九步耗时{}",System.currentTimeMillis()-time);
                    return new BdDistance(distance, duration);
                }
            }
        } catch (Exception e) {
           log.error("调用百度出错了");
        }
        log.error("调用百度出错了使用直径距离估算");
        double dis = JDistanceUtil.calculatePro(x, y, x1, y1);
        return new BdDistance((int)dis, 0);
    }

    public static List<BdDistance> queryDistanceBatch(List<QueryBatch> reqs) {
        if(CollectionUtils.isEmpty(reqs)){
            log.error("批处理不能为空");
            return null;
        }
        long time=System.currentTimeMillis();
        Map<String,Object> map=new HashMap<>();
        map.put("reqs",reqs);
        HttpHeaders header=new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity=new HttpEntity<>(JSONObject.toJSONString(map),header);
        String res = template.postForObject("http://api.map.baidu.com/batch", entity, String.class);
        JSONObject jsonObject = JSONObject.parseObject(res);
        if(jsonObject.getInteger("status").equals(0) && jsonObject.getJSONArray("batch_result")!=null){
            JSONArray batch_result = jsonObject.getJSONArray("batch_result");
            List<BdDistance> list=new ArrayList<>();
            for (int i = 0; i < batch_result.size(); i++) {
                JSONObject singleDistance = batch_result.getJSONObject(i);
                if (singleDistance.getInteger("status") == 0) {
                    JSONObject result = singleDistance.getJSONObject("result");
                    JSONArray routes = result.getJSONArray("routes");
                    if (routes.size() > 0) {
                        Integer distance = routes.getJSONObject(0).getInteger("distance");
                        Integer duration = routes.getJSONObject(0).getInteger("duration");
                        list.add(new BdDistance(distance, duration));
                    }
                }else {
                    log.error("百度批量调用接口出错了{}",singleDistance.getString("message"));
                }
            }
            log.info("调用耗时{}",System.currentTimeMillis()-time);
            return list;
        }
        log.error("批量调用接口出错了{}",res);
        return null;
    }

    public static List<BdDistance> queryDistanceBatchInner(List<BdGeoBatch> batches) {
        if(CollectionUtils.isEmpty(batches)){
            log.error("批处理不能为空");
            return null;
        }
        List<QueryBatch> reqs =new ArrayList<>();
        for (BdGeoBatch batch : batches) {
            String origin=batch.getY()+","+batch.getX();
            String dest=batch.getY1()+","+batch.getX1();
            QueryBatch queryBatch=new QueryBatch("get","/directionlite/v1/driving?origin="+origin+"&destination="+dest+"&ak=wLOTOq8GrpYo7Hu70KM96DmdqU40rjr0&tactics=3");
            reqs.add(queryBatch);
        }
        return queryDistanceBatch(reqs);
    }

    /**
     * 获得周几
     * @param date 1
     * @return 周几
     */
    public static String getWeekDesc(Date date){
        Calendar calendar = DateUtils.toCalendar(date);
        return map.get(calendar.get(Calendar.DAY_OF_WEEK)-1);
    }









    public static void main(String[] args) {

        BDMapUtil bdMapUtil=new BDMapUtil();
       // GeoConvertDto geoConvertDto = bdMapUtil.geoConvert(115.841818, 28.740776);
        //  String geoConvertDto = bdMapUtil.geoConvertStr(115.841818, 28.740776);
       // System.out.println(geoConvertDto.toString());

       // JSONObject geo = bdMapUtil.geocoding("浙江雁荡山");
/*        String geo = bdMapUtil.geocoding("浙江雁荡山");
        JSONObject jsonObject = JSONObject.parseObject(geo);
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject location = result.getJSONObject("location");
        Double lng = location.getDouble("lng");
        Double lat = location.getDouble("lat");

        String s = lat + "," + lng;
        String jsonObject1 = bdMapUtil.geocodingA(s);
        JSONObject addressComponent = JSONObject.parseObject(jsonObject1);
        JSONObject string1 = addressComponent.getJSONObject("result").getJSONObject("addressComponent");
        String string = string1.getString("adcode");
        System.out.println(string);
        System.out.println(jsonObject1);

        System.out.println(geo);*/
       // List<BusinessAreaDto> hotels = bdMapUtil.queryBusinessAreaDto("酒店", "28.742594,115.847207", 3000,null, null);
//        for (BusinessAreaDto hotel : hotels) {
//
//            System.out.println(hotel.getAddress());
//        }
        Date date = new Date();
        Date date1 = DateUtils.addDays(date, 1);
        Date date2 = DateUtils.addDays(date, 2);
        Date date3 = DateUtils.addDays(date, 3);
        Date date4 = DateUtils.addDays(date, 4);
        Date date5 = DateUtils.addDays(date, 5);
        Date date6 = DateUtils.addDays(date, 6);
        Date date7 = DateUtils.addDays(date, 7);
        Calendar calendar = DateUtils.toCalendar(date3);
        int i = calendar.get(Calendar.DAY_OF_WEEK) ;
        System.out.println(i);
        // BDMapUtil.queryDistance(116.452562,39.936404,116.339303,40.01116);
//        GeoConvertDto geoConvertDto = BDMapUtil.geoConvert(114.348025, 30.497468);
//        System.out.println(geoConvertDto.getResult());
    }
}
