package com.example.springboot03.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yanhao
 * @data 2023/11/1
 * <p>
 * CREATE TABLE `app_project` (
 * `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
 * `name` varchar(100) DEFAULT NULL COMMENT '项目名称',
 * `detail` text COMMENT '项目详情',
 * `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
 * `create_user_id` bigint DEFAULT NULL COMMENT '创建用户',
 * `platform_id` bigint DEFAULT NULL COMMENT '平台ID',
 * `update_user_id` bigint DEFAULT NULL,
 * `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '0:未删除，1：已删除',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目表';
 */
@Data
@TableName("app_project")
public class AppProjectEntity extends Model<AppProjectEntity> implements Serializable {
    @TableId
    private Long id;
    private String name;
    private String detail;

    //JSONField来源于fastjson
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Long createUserId;
    private Long platformId;
    private Long updateUserId;

    @TableLogic
    private Integer isDeleted;
}
