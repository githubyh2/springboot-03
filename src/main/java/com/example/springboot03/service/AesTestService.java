package com.example.springboot03.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot03.bean.AesTestEntity;

/**
 * @author yanhao
 * @data 2024/1/10
 */
public interface AesTestService extends IService<AesTestEntity> {

    Integer addAes(AesTestEntity aesTestEntity);
}
