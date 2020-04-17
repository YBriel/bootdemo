package com.boot.bootdemo.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/17   22:00
 */
public class OrderEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderEvent(Object source) {
        super(source);
    }
}
