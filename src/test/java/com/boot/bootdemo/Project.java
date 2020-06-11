package com.boot.bootdemo;

import lombok.Builder;
import lombok.Data;

/**
 * 项目
 * 在哪里以及如何使用ambda
 * 函数描述符
 * FunctionalInterface
 * 函数式接口，类型推断
 * @author biezhi
 * @date 2018/2/9
 */
@Data
@Builder
public class Project {

    /**
     * 项目名称
     */
    private String  name;

    /**
     * 编程语言
     */
    private String  language;

    /**
     * star 数
     */
    private Integer stars;

    /**
     * 描述
     */
    private String  description;

    /**
     * 作者
     */
    private String  author;

}
