package com.example.springboot03.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot03.bean.AesTestEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yanhao
 * @data 2024/1/10
 */
@Mapper
public interface AesTestMapper extends BaseMapper<AesTestEntity> {
}
