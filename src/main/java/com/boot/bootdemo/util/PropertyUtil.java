package com.boot.bootdemo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
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

        InputStream stream = UtilProperty.class.getClassLoader().getResourceAsStream("config.properties");
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
}
