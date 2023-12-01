package com.example.springboot03.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot03.bean.Employees;
import com.example.springboot03.dao.EmployeesMapper;
import com.example.springboot03.service.EmployeesService;
import org.springframework.stereotype.Service;

/**
 * @author yanhao
 * @data 2023/12/1
 */
@Service
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements EmployeesService {
}
