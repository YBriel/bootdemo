package com.boot.bootdemo.util;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-03-31 09:52
 **/
public class WeekDayUtil {

    public static final Map<Integer,String> map=new HashMap<>();

    static {
        map.put(0,"周日");
        map.put(1,"周一");
        map.put(2,"周二");
        map.put(3,"周三");
        map.put(4,"周四");
        map.put(5,"周五");
        map.put(6,"周六");
    }

    /**
     * 获得周几
     * @param date 1
     * @return 周几
     */
    public static String getWeekDesc(Date date){
        Calendar calendar = DateUtils.toCalendar(date);
        return map.get(calendar.get(Calendar.DAY_OF_WEEK)-1);
    }

    public static void main(String[] args) {

        System.out.println(WeekDayUtil.getWeekDesc(new Date()));
    }


}
