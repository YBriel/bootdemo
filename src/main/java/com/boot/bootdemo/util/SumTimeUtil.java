package com.boot.bootdemo.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * author: yuzq
 * create: 2021-03-05 21:31
 **/
@Data
@Slf4j
public class SumTimeUtil {
    public   static final Map<Long,DriverTime> map=new HashMap<>();



    public DriverTime driverTimeCal(Long userId,Long timeStamp){
        DriverTime driverTime = map.get(userId);
        if (driverTime==null){
            log.info("初始化司机时间参数");
            driverTime=new DriverTime(0L,userId,timeStamp);
        }else {
            long l = timeStamp - driverTime.getLastTimeStamp();
            if(l >0 && l<=1000 ){
                log.info("打点有效");
                driverTime.setLastTimeStamp(timeStamp);
                driverTime.setSumTime(driverTime.getSumTime()+l);
            }else if(l>1000){
                log.info("重新打点");
                driverTime.setLastTimeStamp(timeStamp);
            }
        }
        map.put(userId,driverTime);
        return driverTime;
    }

    public class DriverTime{
       // private Long currentTime;
        private Long sumTime;
        private Long userId;
        private Long lastTimeStamp;

        public DriverTime() {
        }

        public DriverTime( Long sumTime, Long userId, Long lastTimeStamp) {
          //  this.currentTime = currentTime;
            this.sumTime = sumTime;
            this.userId = userId;
            this.lastTimeStamp = lastTimeStamp;
        }

/*        public Long getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(Long currentTime) {
            this.currentTime = currentTime;
        }*/

        public Long getSumTime() {
            return sumTime;
        }

        public void setSumTime(Long sumTime) {
            this.sumTime = sumTime;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getLastTimeStamp() {
            return lastTimeStamp;
        }

        public void setLastTimeStamp(Long lastTimeStamp) {
            this.lastTimeStamp = lastTimeStamp;
        }
    }
}
