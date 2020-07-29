package com.boot.bootdemo;

import com.boot.bootdemo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 * description:
 * author: yuzq
 * date: 2020/5/25 14:43
 */
public class LogTest {

    private static Logger logger= LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {

        String aa="20200728南昌易至出行订单数据.xlsx";
        System.out.println(aa.getBytes().length);
/*        logger.info("这是info");
        logger.warn("这是warn");
        logger.debug("这是debug");
        logger.error("这是error");
        logger.trace("这是trace");
        Student student=new Student();
        student.setAge(22);
        student.setName("tom");
        logger.info("ss",student.getName());*/
    }
}
