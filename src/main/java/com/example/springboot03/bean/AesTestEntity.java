package com.example.springboot03.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.example.springboot03.enum01.SexEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yanhao
 * @data 2024/1/10
 */
@Data
@TableName(value = "aes_test")
public class AesTestEntity implements Serializable {
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

    @TableField("user_name")
    private String userName;

    @TableField("sex_enum")
    private SexEnum sexEnum;

    @TableField("password")
    private String password;

    @TableLogic(value = "N", delval = "Y")
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private String delFlag;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
