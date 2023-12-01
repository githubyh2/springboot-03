package com.example.springboot03.bean;

/**
 * @author yanhao
 * @data 2023/12/1
 */

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * CREATE TABLE `employees` (
 * `emp_no` int NOT NULL,
 * `birth_date` date NOT NULL,
 * `first_name` varchar(14) NOT NULL,
 * `last_name` varchar(16) NOT NULL,
 * `gender` enum('M','F') NOT NULL,
 * `hire_date` date NOT NULL,
 * PRIMARY KEY (`emp_no`)
 * ) ENGINE=InnoDB DEFAULT CH
 */
@TableName("employees")
@Data
public class Employees {
    @TableId(value = "emp_no")
    private Integer empNo;

    @TableField("birth_date")
    private Date birthDate;

    @TableField("first_name")
    private String firstName;

    @TableField("last_name")
    private String lastName;

    @TableField("gender")
    private Gender gender;

    @TableField("hire_date")
    private Date hireDate;
}
