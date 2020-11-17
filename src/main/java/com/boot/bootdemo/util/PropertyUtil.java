package com.boot.bootdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * author: yuzq
 * create: 2020-11-17 16:16
 **/
@Slf4j
public class PropertyUtil {

    private static Properties p=null;

    static {
        p = new Properties();
        String property = System.getProperty("activeProfile");
        if(StringUtils.isEmpty(property) || Arrays.asList("dev","test","prod").indexOf(property)==-1){
            log.error("unable to get right property file,please check your argument, dev will be active");
            property="application.properties";
        }else {
            property="application-"+property+".properties";
        }
        InputStream stream = UtilProperty.class.getClassLoader().getResourceAsStream(property);
        try {
            p.load(stream);
        } catch (IOException e) {
            log.info("读取文件异常");
            e.printStackTrace();
        }

    }

    public String getValueMethod(){
        return p.getProperty("protocolMode")==null?null:p.getProperty("protocolMode").toString();
    }

    public static String getProperties(String key){
        return  p.getProperty(key);
    }

    public static Object setProperties(String key,String va){
        return p.setProperty(key, va);
    }
}
