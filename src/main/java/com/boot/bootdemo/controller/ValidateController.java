package com.boot.bootdemo.controller;

import com.boot.bootdemo.config.ValidationResult;
import com.boot.bootdemo.config.ValidationUtil;
import com.boot.bootdemo.entity.ValidateEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * author: yuzq
 * create: 2020-08-07 09:08
 **/
@RestController
@RequestMapping("/validate")
public class ValidateController {


    @RequestMapping("/saySomething")
    public String saySomething( @RequestBody ValidateEntity validateEntity ){

        ValidationResult validationResult = ValidationUtil.validateEntity(validateEntity);
        Map<String, String> errorMsg = validationResult.getErrorMsg();
        System.out.println(errorMsg);
        System.out.println(validateEntity);
        return validateEntity.getName();
    }


}
