package com.boot.bootdemo.service;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 *1.创建新实例。
 *
 *  DateFormat df = new SimpleDateFormat("yyyy-mm-dd")
 *
 *  Date excuDate=df.parse("1970-01-01");
 *
 *
 * simpleDateFormat线程不安全
 * 2 改为apache的commons-lang包的DateUtils和DateFormatUtils类，这两个类的方法是线程安全的
 * author: yuzq
 * create: 2021-01-27 20:51
 **/
public class DateService {

    public static void main(String[] args) throws ParseException {

        String format = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(format);
        Date date = DateUtils.parseDate("2021-01-27", new String[]{"yyyy-MM-dd"});
        System.out.println(date);

    }
}
