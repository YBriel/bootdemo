package com.boot.bootdemo.util.hikvision;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuzq
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BusLineStation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 线路id
     */
    private Long lineId;

    /**
     * 站点名称
     */
    private String stationName;

    /**
     * 经度
     */
    private Double lng;
    /**
     * 纬度
     */
    private Double lat;
    /**
     * 地址
     */
    private String address;

    /**
     * 城市code
     */
    private String regionCode;

    /**
     * 站点顺序
     */
    private Integer stationIndex;

    /**
     * 去程1 回程2
     */
    private Integer tag;

    @JsonIgnore
    @JSONField(serialize = false)
    private Date createTime;

    @JsonIgnore
    @JSONField(serialize = false)
    private Date updateTime;

    @JsonIgnore
    @JSONField(serialize = false)
    private Integer state;

    /**
     * 是否收藏
     */
    @TableField(exist = false)
    private Boolean favorite;
}
