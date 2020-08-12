package com.boot.bootdemo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * author: yuzq
 * create: 2020-08-07 09:09
 **/
@Data
public class ValidateEntity {

    @Length(min = 4)
    private String name;

    @Min(11)
    private Integer age;


   // private Date date;
}
