package com.boot.bootdemo.util.hikvision;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author: yuzq
 * create: 2021-05-14 10:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTopicInfoRequest {

    private List<String> eventTypes;

}
