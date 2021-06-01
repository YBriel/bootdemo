package com.boot.bootdemo.util.hikvision;

/**
 * author: yuzq
 * create: 2021-05-14 17:21
 **/
public class GeoTransferUtil {

    private static final int a=360000;
    private static final int b=6000;
    private static final int c=100;

    public static String toLng(Integer lng){

        int i = lng % a;
        int du=lng/a;
        int fen = lng - a * du;
        int i1 = fen / b;
        int i2 = fen - i1 * b;
       // double i3 = (double)i2 / c;
        return du+"."+i1+""+i2;
    }

    public static void main(String[] args) {
        System.out.println(GeoTransferUtil.toLng(42126056)+","+GeoTransferUtil.toLng(10016794));
        int i = (117 * 360000) + (6000) + 56;
        System.out.println(i);
    }
}
