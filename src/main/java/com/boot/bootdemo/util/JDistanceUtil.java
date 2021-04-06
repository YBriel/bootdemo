package com.boot.bootdemo.util;

/**
 * author: yuzq
 * create: 2021-02-04 09:48
 **/
public class JDistanceUtil {

    // 圆周率
    public static final double PI = 3.14159265358979324;
    // 赤道半径(单位m)
    private static final  double EARTH_RADIUS = 6378137;

    /**
     * 转化为弧度(rad)
     * */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
    /**
     * 基于googleMap中的算法得到两经纬度之间的距离,
     * 计算精度与谷歌地图的距离精度差不多，相差范围在0.2米以下
     * @param lon1 第一点的经度
     * @param lat1 第一点的纬度
     * @param lon2 第二点的经度
     * @param lat2 第二点的纬度
     * @return 返回的距离，单位km
     * */
    public static double calculate(double lon1,double lat1,double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        //s = Math.round(s * 10000) / 10000;
        return (double) Math.round((s/1000) * 100) / 100;

        //return s/1000;
    }

    public static double calculatePro(double lon1,double lat1,double lon2, double lat2) {
        try {
            return calculate(lon1, lat1, lon2, lat2)*1000;
        }catch (Exception e){
            return 0;
        }

        //return s/1000;
    }

    /**
     * 计算直线距离
     * @param x 经度
     * @param y 纬度
     * @param x1 经度
     * @param y1 纬度
     * @return 直线距离
     */
    @Deprecated
    public static double calculate1(double x, double y, double x1, double y1) {
        return Math.sqrt(Math.abs((x -x1)* ( - x1)+(y - y1)* (y - y1)));
    }


    public static void main(String[] args) {
        //115.839401,28.742857
        //115.855023,28.742556
     //   System.out.println(JDistanceUtil.calculate(115.839401,28.742857,115.855023,28.742556));
        System.out.println(JDistanceUtil.calculate(102.839713,24.851415,102.833669,24.881490));
        System.out.println(JDistanceUtil.calculate(102.833669,24.881490,102.839713,24.851415));
        System.out.println(JDistanceUtil.calculate(115.841432,28.742509,115.860915,28.743262));
        System.out.println(JDistanceUtil.calculate(115.860915,28.743262,115.841432,28.742509));

        System.out.println(JDistanceUtil.calculate1(102.839713,24.851415,102.833669,24.881490));
        System.out.println(JDistanceUtil.calculate1(102.833669,24.881490,102.839713,24.851415));
        System.out.println(JDistanceUtil.calculate1(115.841432,28.742509,115.860915,28.743262));
        System.out.println(JDistanceUtil.calculate1(115.860915,28.743262,115.841432,28.742509));

        int ceil = (int) Math.ceil(1.9d - 2);
        System.out.println(ceil);
    }

}

/*class Point {
    double num1, num2;

    Point(double i, double j) {
        num1 = i;
        num2 = j;
    }
}*/
