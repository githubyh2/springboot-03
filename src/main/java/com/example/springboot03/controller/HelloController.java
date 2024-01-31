package com.example.springboot03.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.springboot03.bean.AesTestEntity;
import com.example.springboot03.enum01.SexEnum;
import com.example.springboot03.service.AesTestService;
import com.example.springboot03.util.AESUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanhao
 * @data 2023/10/29
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private AesTestService aesTestService;

    @RequestMapping("/sayHello")
    public String sayHello() {
        log.info("the method is called。。。。。");
        long id = IdWorker.getId();
        log.info("--" + id);
        return "hello,springboot!!!!";
    }

    @PostMapping("/insert")
    public Integer insertTest(AesTestEntity aesTestEntity) throws Exception {

        if (aesTestEntity == null) {
            return -1;
        }
        if (aesTestEntity != null) {
            String password = aesTestEntity.getPassword();
            String encrypt = AESUtils.encrypt(password);
            aesTestEntity.setPassword(encrypt);
            aesTestEntity.setSexEnum(SexEnum.MALE);
        }
        System.out.println("aesTestEntity = " + aesTestEntity);
        return aesTestService.addAes(aesTestEntity);
    }

    @PostMapping("/query")
    public AesTestEntity get(Long userId) throws Exception {
        AesTestEntity aesTestEntity = aesTestService.getById(userId);
        String password = aesTestEntity.getPassword();
        String decrypt = AESUtils.decrypt(password);
        aesTestEntity.setPassword(decrypt);
        return aesTestEntity;

    }

    @PostMapping("/delete")
    public Boolean deleteTest(Long userId) {
        return aesTestService.removeById(userId);
    }

}
