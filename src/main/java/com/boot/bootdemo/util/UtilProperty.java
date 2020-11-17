package com.boot.bootdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

@Slf4j
public class UtilProperty {

    private static Properties p;

    static {
         p = new Properties();
        String property = System.getProperty("activeProfile");
        if(StringUtils.isEmpty(property) || Arrays.asList("dev","test","prod").indexOf(property)==-1){
            log.error("unable to get right property file,please check your argument, dev will be active");
            property="application-dev.properties";
        }else {
            property="application-"+property+".properties";
        }
      //  InputStream stream = UtilProperty.class.getClassLoader().getResourceAsStream(property);

        InputStream stream = UtilProperty.class.getClassLoader().getResourceAsStream(property);
        assert stream != null;
        BufferedReader bf = null;
        bf = new BufferedReader(new InputStreamReader(stream,StandardCharsets.UTF_8));
        try {
            p.load(bf);
        } catch (IOException e) {
            log.info("配置文件读取异常");
            e.printStackTrace();
        }

    }

    public static String getProperties(String key){
        return  p.getProperty(key);
    /*    if(StringUtils.isNotEmpty(property)){
            return new String(property.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        }
        return null;*/
    }

    public String getValueMethod(){
        return p.getProperty("protocolMode")==null?null:p.getProperty("protocolMode").toString();
    }

}