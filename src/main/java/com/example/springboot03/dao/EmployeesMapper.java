package com.example.springboot03.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot03.bean.Employees;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yanhao
 * @data 2023/12/1
 */
@Mapper
public interface EmployeesMapper extends BaseMapper<Employees> {
}
