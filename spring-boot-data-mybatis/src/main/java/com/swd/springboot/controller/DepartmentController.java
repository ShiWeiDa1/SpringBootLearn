package com.swd.springboot.controller;

import com.swd.springboot.bean.Department;
import com.swd.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    public DepartmentMapper deptMapper;

    /**
     * 根据部门id,获取部门信息
     * @param id
     * @return
     */
    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        Department department = deptMapper.getDepartmentById(id);
        return department;
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        System.out.println(department);
        deptMapper.insertDepartment(department);
        return department;
    }

}
