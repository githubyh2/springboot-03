package com.example.springboot03.service;

import com.example.springboot03.bean.Employees;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author yanhao
 * @data 2023/12/1
 */
@SpringBootTest
public class EmployeesServiceTest {

    @Autowired
    private EmployeesService employeesService;

    @Test
    public void testQuery() {
        List<Integer> integerList = Arrays.asList(10001, 10010, 10020);
        List<Employees> employeesList = employeesService.listByIds(integerList);

        employeesList.forEach(System.out::println);
    }
}
