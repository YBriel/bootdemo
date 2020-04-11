package com.boot.bootdemo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

import java.util.Set;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/3/7   12:10
 */
public class ApolloTest {

    public static void main(String[] args) {

        Config appConfig = ConfigService.getAppConfig();
        Set<String> propertyNames = appConfig.getPropertyNames();
        for (String propertyName : propertyNames) {
            System.out.println(propertyName+appConfig.getProperty(propertyName,propertyName));
        }
    }
}
