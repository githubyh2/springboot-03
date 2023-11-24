package com.example.springboot03.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot03.bean.AppProjectEntity;
import com.example.springboot03.dao.AppProjectDao;
import com.example.springboot03.service.AppProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanhao
 * @data 2023/11/1
 */
@Service("AppProjectService")
public class AppProjectServiceImpl extends ServiceImpl<AppProjectDao, AppProjectEntity> implements AppProjectService {

}
