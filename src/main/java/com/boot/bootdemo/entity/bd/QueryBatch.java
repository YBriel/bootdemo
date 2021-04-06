package com.boot.bootdemo.entity.bd;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * author: yuzq
 * create: 2021-03-30 14:44
 **/
@Data
public class QueryBatch {

    private String method;
    private String url;

    public QueryBatch() {

    }

    public QueryBatch(String method, String url) {
        this.method = method;
        this.url = url;
    }

    public static void main(String[] args) {
        List<QueryBatch> list=new ArrayList<>();
        list.add(new QueryBatch("1","32"));
        list.add(new QueryBatch("1","32"));
        list.add(new QueryBatch("1","32"));
        list.add(new QueryBatch("1","32"));

        System.out.println(JSON.toJSONString(list));
    }
}
