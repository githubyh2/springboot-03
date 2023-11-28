package com.example.springboot03.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot03.bean.AppProjectEntity;
import com.example.springboot03.dao.AppProjectDao;
import com.example.springboot03.service.AppProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yanhao
 * @data 2023/11/1
 */
@Slf4j
@RestController
public class AppProjectController {
    @Autowired
    private AppProjectDao appProjectDao;

    @Autowired
    private AppProjectService appProjectService;

    @GetMapping("/test-mybatis-plus")
    public void test() {
        AppProjectEntity entity = new AppProjectEntity();
        entity.setId(1L);

        QueryWrapper<AppProjectEntity> queryWrapper = new QueryWrapper<>(entity);
        List<AppProjectEntity> appProjectEntities = appProjectDao.selectList(queryWrapper);

        appProjectEntities.forEach(System.out::println);
    }


    @GetMapping("/testCount")
    public void testCount() {
        long count = appProjectService.count();
        System.out.println("----" + count);
    }


    @GetMapping("/testServer")
    public void testServer() {
        AppProjectEntity byId = appProjectService.getById(1L);
        String detail = byId.getDetail();
        System.out.println("----" + detail);
    }


    @GetMapping("/sayHello")
    public String sayHello() {
        Date d = new Date(1664180292 * 1000L);
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        return "sayHello......" + str;
    }

    @GetMapping("/test01")
    public void test01() {

        // 获取虚拟机可用得最大处理器数量
        int availableProcessors = Runtime.getRuntime().availableProcessors();

        System.out.println("虚拟机可用的最大处理器数量是：" + availableProcessors);

        int maxValue = Integer.MAX_VALUE;  // 2147483647
        System.out.println("===" + maxValue);
    }

}
