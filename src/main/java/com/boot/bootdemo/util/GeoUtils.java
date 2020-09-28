package com.boot.bootdemo.util;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * author: yuzq
 * create: 2020-09-28 09:57
 **/
public class GeoUtils {


    /**
     * 判断点是否在多边形内
     * @param point 检测点
     * @param pts   多边形的顶点
     * @return      点在多边形内返回true,否则返回false
     */
    public static boolean IsPtInPoly(Point2D.Double point, List<Point2D.Double> pts){

        int N = pts.size();
        boolean boundOrVertex = true; //如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
        int intersectCount = 0;//cross points count of x
        double precision = 2e-10; //浮点类型计算时候与0比较时候的容差
        Point2D.Double p1, p2;//neighbour bound vertices

        p1 = pts.get(0);//left vertex
        for(int i = 1; i <= N; ++i){//check all rays
            if(point.equals(p1)){
                return true;//p is an vertex
            }

            p2 = pts.get(i % N);//right vertex
            if(point.x < Math.min(p1.x, p2.x) || point.x > Math.max(p1.x, p2.x)){//ray is outside of our interests
                p1 = p2;
                continue;//next ray left point
            }

            if(point.x > Math.min(p1.x, p2.x) && point.x < Math.max(p1.x, p2.x)){//ray is crossing over by the algorithm (common part of)
                if(point.y <= Math.max(p1.y, p2.y)){//x is before of ray
                    if(p1.x == p2.x && point.y >= Math.min(p1.y, p2.y)){//overlies on a horizontal ray
                        return true;
                    }

                    if(p1.y == p2.y){//ray is vertical
                        if(p1.y == point.y){//overlies on a vertical ray
                            return true;
                        }else{//before ray
                            ++intersectCount;
                        }
                    }else{//cross point on the left side
                        double xinters = (point.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;//cross point of y
                        if(Math.abs(point.y - xinters) < precision){//overlies on a ray
                            return true;
                        }

                        if(point.y < xinters){//before ray
                            ++intersectCount;
                        }
                    }
                }
            }else{//special case when ray is crossing through the vertex
                if(point.x == p2.x && point.y <= p2.y){//p crossing over p2
                    Point2D.Double p3 = pts.get((i+1) % N); //next vertex
                    if(point.x >= Math.min(p1.x, p3.x) && point.x <= Math.max(p1.x, p3.x)){//p.x lies between p1.x & p3.x
                        ++intersectCount;
                    }else{
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;//next ray left point
        }

        //偶数在多边形外
        //奇数在多边形内
        return intersectCount % 2 != 0;

    }

    public static void main(String[] args) {
        Point2D.Double point = new Point2D.Double(115.911375, 28.857874);
        Point2D.Double point1 = new Point2D.Double(115.911718, 28.858250);

        List<Point2D.Double> pts = new ArrayList<>();
        pts.add(new Point2D.Double(115.911203,28.880574));
        pts.add(new Point2D.Double(115.929914,28.871555));
        pts.add(new Point2D.Double(115.91189,28.836974));
        pts.add(new Point2D.Double(115.891119,28.845094));

        if(IsPtInPoly(point, pts)){
            System.out.println("点在多边形内");
        }else{
            System.out.println("点在多边形外");
        }

        if(IsPtInPoly(point1, pts)){
            System.out.println("点在多边形内");
        }else{
            System.out.println("点在多边形外");
        }
    }
}
