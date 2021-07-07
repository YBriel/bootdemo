package com.boot.bootdemo.util.hikvision;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * author: yuzq
 * create: 2021-07-07 19:30
 **/
@Slf4j
public class AmapDemo {

    private RestTemplate restTemplate;

    @RequestMapping("test")
    public void test(){
        List<BusLineStation> busLineStations = new ArrayList<>();
    //    List<BusLineStation> busLineStations = stationService.queryBusStationListByLineId(361000110L);
        busLineStations.sort(Comparator.comparingInt(BusLineStation::getStationIndex));
        int jj=0;
        for (int i = 0; i < busLineStations.size()-1; i++) {
            BusLineStation busLineStation = busLineStations.get(i);
            BusLineStation busLineStation1 = busLineStations.get(i + 1);
            String begin=busLineStation.getLng()+","+busLineStation.getLat();
            String end=busLineStation1.getLng()+","+busLineStation1.getLat();
            String url="https://restapi.amap.com/v3/direction/driving?key=2701269d1c8251016352cef162e2bdb3&origin="+begin+"&destination="+end;
            String result = restTemplate.getForObject(url, String.class);
            JSONObject jsonObject = JSONObject.parseObject(result);
            JSONObject route = jsonObject.getJSONObject("route");
            JSONArray paths = route.getJSONArray("paths");
            JSONObject jsonObject1 = paths.getJSONObject(0);
            JSONArray steps = jsonObject1.getJSONArray("steps");
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < steps.size(); j++) {
                JSONObject jsonObject2 = steps.getJSONObject(j);
                String polyline = jsonObject2.getString("polyline");
                sb.append(polyline).append(";");
            }
            String s = sb.toString();
            String[] split = s.split(";");
            for (String s1 : split) {
                try {
                    String[] split1 = s1.split(",");
                    String s2 = split1[0];
                    String s3 = split1[1];
                    BusLineGeos busLineGeos=new BusLineGeos();
                    jj=jj+1;
                    busLineGeos.setLineId(361000110L).setPreStationId(busLineStation.getId()).setNextStationId(busLineStation1.getId())
                            .setLng(Double.parseDouble(s2)).setLat(Double.parseDouble(s3)).setPointType(2).setPointTag(jj);
//                    busLineGeoService.save(busLineGeos);
                }catch (DuplicateKeyException ignored){

                }
            }
            log.info("busLineStation:{},{}polyLine{}",busLineStation.getStationName(),busLineStation1.getStationName(),sb.toString());
        }
    }
}
