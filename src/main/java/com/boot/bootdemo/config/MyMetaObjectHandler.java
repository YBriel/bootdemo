package com.boot.bootdemo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  <p> MyBatisPlus自定义字段自动填充处理类 - 实体类中使用 @TableField注解 </p>
 *
 * description: 注意前端传值时要为null
 * author: yuzq
 * date: 2019/8/18 0018 1:46
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    /**
     * 创建时间
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        LOG.info(" -------------------- start insert fill ...  --------------------");
        if (metaObject.hasGetter("createTime") && metaObject.hasGetter("updateTime")&& metaObject.hasGetter("state")) {
            setFieldValByName("createTime", new Date(), metaObject);
            setFieldValByName("updateTime", new Date(), metaObject);
            setFieldValByName("state", 1, metaObject);
        }
    }

    /**
     * 最后一次更新时间
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        LOG.info(" -------------------- start update fill ...  --------------------");
        if (metaObject.hasGetter("updateTime")) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }
    }
    
}
