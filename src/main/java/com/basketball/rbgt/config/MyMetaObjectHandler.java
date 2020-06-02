package com.basketball.rbgt.config;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill....");
        log.info("metaObject -> {}", JSON.toJSONString(metaObject));
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update  fill....");
        log.info("metaObject -> {}", JSON.toJSONString(metaObject));
        Field[] fields = metaObject.getOriginalObject().getClass().getFields();
        System.out.println(JSON.toJSONString(fields));
        for(Field f : fields){
            System.out.println(f);
        }
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}