package com.example.springboot03.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springboot03.bean.Employees;
import com.example.springboot03.dao.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yanhao
 * @data 2023/12/1
 */
@RestController
public class EmployesController {
    @Autowired
    private EmployeesMapper employeesMapper;


    @GetMapping("/testWrapper")
    public void testWrapper() {

        // 构建查询条件
        /*
        // 使用 QueryWrapper 实现 where 查询条件拼接
        // 实现：SELECT emp_no,birth_date FROM employees WHERE (last_name LIKE ? AND emp_no <= ?)
        QueryWrapper<Employees> queryWrapper = new QueryWrapper<Employees>()
                .select("emp_no", "birth_date", "first_name", "gender")
                .eq("last_name", "Facello")
                .le("emp_no", 10500);
        */

        // 使用 LambdaQueryWrapper 实现 where 查询条件拼接
        // 实现：SELECT emp_no,birth_date FROM employees WHERE (last_name LIKE ? AND emp_no <= ?)
        LambdaQueryWrapper<Employees> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Employees::getEmpNo, Employees::getBirthDate);
        queryWrapper.like(Employees::getLastName, "Facello");
        queryWrapper.le(Employees::getEmpNo, 10500);

        // 查询
        List<Employees> employees = employeesMapper.selectList(queryWrapper);

        employees.forEach(System.out::println);
    }

    @GetMapping("/test")
    public String test() {
        return "aaa";
    }
}
