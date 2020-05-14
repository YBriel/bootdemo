package com.boot.bootdemo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * author: yuzq
 * create: 2020-05-14 18:49
 **/
@Getter
@Setter
public  abstract class BaseEntity<T extends Model<T>> extends Model<T> implements Serializable {

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "state",fill = FieldFill.INSERT)
    private int state;
}
