package com.boot.bootdemo.component;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * author: yuzq
 * create: 2020-06-19 16:06
 **/
public class MyConditional implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            conditionContext.getEnvironment().getActiveProfiles();
        return false;
    }
}
