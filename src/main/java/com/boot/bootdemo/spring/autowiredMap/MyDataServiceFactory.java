package com.boot.bootdemo.spring.autowiredMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: yuzq
 * create: 2020-10-28 09:43
 **/
@Service
@Slf4j
@Data
public class MyDataServiceFactory {

    @Autowired
    private Map<String, DataServiceDemo> map = new ConcurrentHashMap<>();
/*    @Bean(name="dataServiceDemo")
    public Map<String, DataServiceDemo> getDataServiceDemo(){
        return  new HashMap<>();

    }*/


    /*@Autowired
    private List<DataServiceDemo> list=new ArrayList<>();*/

    @PostConstruct
    public void init(){
      map.forEach((k,y)->{
          log.info("map构造开始打印参数...");
          log.info(y.toString());
          log.info(k+"-----"+map.get(k));
      });
    }
/*    public DataServiceDemo getProcessor(String name){
        return map.get(name);
    }*/
}
