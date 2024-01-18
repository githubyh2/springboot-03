package com.example.springboot03.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot03.bean.AesTestEntity;
import com.example.springboot03.dao.AesTestMapper;
import com.example.springboot03.service.AesTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanhao
 * @data 2024/1/10
 */
@Service
public class AesTestServiceImpl extends ServiceImpl<AesTestMapper, AesTestEntity> implements AesTestService {
    @Autowired
    private AesTestMapper aesTestMapper;


    @Override
    public Integer addAes(AesTestEntity aesTestEntity) {
        return aesTestMapper.insert(aesTestEntity);
    }
}
