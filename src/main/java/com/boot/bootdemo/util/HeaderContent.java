package com.boot.bootdemo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * author: yuzq
 * create: 2021-01-28 10:08
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class HeaderContent {

    private String partnerCode;
    private String requestType;
    private String signature;
    private Long timestamp;
    private String version;

    public static HeaderContent build(String requestType,String signature,Long timestamp){
        HeaderContent content=new HeaderContent();
        content.setPartnerCode("P10000119").setRequestType(requestType)
                .setSignature(signature).setTimestamp(timestamp).setVersion("1.0.0");
        return content;
    }
}
