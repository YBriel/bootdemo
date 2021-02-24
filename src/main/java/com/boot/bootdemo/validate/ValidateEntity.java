package com.boot.bootdemo.validate;

import lombok.Data;


import javax.validation.constraints.*;
import java.util.Date;

/**
 * author: yuzq
 * create: 2021-02-24 20:26
 **/
@Data
public class ValidateEntity {
    @NotEmpty
    private String name;
    @NotBlank
    private String name1;

    @NotBlank(groups = {CompanyGroup.class, MicroBusinessGroup.class})
    private String hobby;

    @Min(value = 4,groups = {CompanyGroup.class, IndividualGroup.class})
    @Digits(integer = 2,fraction = 0,message = "数字错了")
    private Integer age;

    @Past(groups = MicroBusinessGroup.class)
    private Date date;

}
