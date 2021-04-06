package com.boot.bootdemo.entity.bd;

import lombok.Data;

/**
 * author: yuzq
 * create: 2021-03-30 15:00
 **/
@Data
public class BdGeoBatch {

    private Double x;
    private Double y;
    private Double x1;
    private Double y1;


    public BdGeoBatch() {
    }

    public BdGeoBatch(Double x, Double y, Double x1, Double y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }
}
