package com.example.springboot03.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot03.bean.AppProjectEntity;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

/**
 * @author yanhao
 * @data 2023/11/1
 */
@Mapper
public interface AppProjectDao extends BaseMapper<AppProjectEntity> {
}