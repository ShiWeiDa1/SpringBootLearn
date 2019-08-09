package com.swd.springboot.controller;

import com.swd.springboot.bean.Department;
import com.swd.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swd
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer id){
        System.out.println("查询的部门id:"+id);
        Department departmentById = departmentService.getDepartmentById(id);
        return departmentById;
    }
}
