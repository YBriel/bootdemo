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
public class MyBigDecimalSerializable extends JsonSerializer<BigDecimal> {

    /**
     * 金钱类型格式化
     */
    private DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void serialize(BigDecimal decimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (decimal != null) {
            jsonGenerator.writeString(df.format(decimal));
        }
    }
}
