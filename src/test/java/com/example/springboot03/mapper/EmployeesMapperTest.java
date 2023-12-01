package com.example.springboot03.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot03.bean.Employees;
import com.example.springboot03.dao.EmployeesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author yanhao
 * @data 2023/12/1
 */
@SpringBootTest
public class EmployeesMapperTest {
    @Autowired
    private EmployeesMapper employeesMapper;

    @Test
    public void testWrapper() {

        // 构建查询条件
        /*
        // 使用 QueryWrapper 实现 where 查询条件拼接
        // 实现：SELECT emp_no,birth_date FROM employees WHERE (last_name LIKE ? AND emp_no <= ?)
        QueryWrapper<Employees> queryWrapper = new QueryWrapper<Employees>()
                .select("emp_no", "birth_date", "first_name", "gender")
                .like("last_name", "Facello")
                .le("emp_no", 10500);
        */

        // 使用 LambdaQueryWrapper 实现 where 查询条件拼接
        // 实现：SELECT emp_no,birth_date FROM employees WHERE (last_name LIKE ? AND emp_no <= ?)
        LambdaQueryWrapper<Employees> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Employees::getEmpNo, Employees::getBirthDate, Employees::getFirstName, Employees::getGender);
        queryWrapper.like(Employees::getLastName, "Facello");
        queryWrapper.le(Employees::getEmpNo, 10500);

        // 进行查询
        List<Employees> employeesList = employeesMapper.selectList(queryWrapper);

        employeesList.forEach(System.out::println);

    }
}
