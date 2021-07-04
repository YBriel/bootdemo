package com.boot.bootdemo.config.serilize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * author: yuzq
 * create: 2021-06-30 11:50
 **/
public class MyIntegerSerializable extends JsonSerializer<Integer> {

    /**
     * 金钱类型格式化
     */
    private DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(value==null){
            gen.writeString("0");
        }else {
            BigDecimal bigDecimal = BigDecimal.valueOf(value);
            BigDecimal divide = bigDecimal.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
            gen.writeString(df.format(divide));
        }

    }
}
