package com.example.springboot03.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @author yanhao
 * @data 2024/1/12
 */
@Configuration
public class MybatisObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        /**
         * 如果要使用LocalDateTime.class  , 对应的 实体类对象中必须是 private LocalDateTime createTime;
         * 如果要使用Date.class  , 对应的 实体类对象中必须是 private Date createTime;
         * 需要类型一致
         */
        strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

//        strictInsertFill(metaObject, "createTime", Date.class, new Date());
//        strictUpdateFill(metaObject, "updateTime", Date.class, new Date());

        strictInsertFill(metaObject, "delFlag", String.class, "N");

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

//        strictUpdateFill(metaObject, "updateTime", Date.class, new Date());

        strictUpdateFill(metaObject, "delFlag", String.class, "Y");

    }
}
