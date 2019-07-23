package com.swd.springboot.controller;

import com.swd.springboot.bean.Employee;
import com.swd.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swd
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeMapper mapper;

    /**
     * 根据员工的id,来查询员工的信息
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable Integer id){
        Employee employee = mapper.getEmployeeById(id);
        return employee;
    }

    /**
     * 插入员工信息
     * @param employee
     * @return
     */
    @GetMapping("/emp")
    public Employee insertEmp(Employee employee){
        System.out.println(employee);


        mapper.insertEmployee(employee);
        return employee;

    }


}
