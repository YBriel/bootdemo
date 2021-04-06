package com.boot.bootdemo.entity.bd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author: yuzq
 * create: 2021-03-18 09:40
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoConvertDto {

    private Integer status;

    private List<Result> result;



    public static class Result{
        private Double x;
        private Double y;

        public Result() {
        }

        public Result(Double x, Double y) {
            this.x = x;
            this.y = y;
        }

        public Double getX() {
            return x;
        }

        public void setX(Double x) {
            this.x = x;
        }

        public Double getY() {
            return y;
        }

        public void setY(Double y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
