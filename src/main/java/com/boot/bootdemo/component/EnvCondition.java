package com.boot.bootdemo.component;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * author: yuzq
 * create: 2020-07-30 18:55
 **/
@Component
public class EnvCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println("activeProfiles..."+Arrays.toString(activeProfiles));
        String property = environment.getProperty("spring.profiles.active");
        System.out.println("property..."+  property);
        return !StringUtils.isEmpty(property) && property.equals("dev");
    }
}
