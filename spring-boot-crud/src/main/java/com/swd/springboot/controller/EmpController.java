package com.swd.springboot.controller;

import com.swd.springboot.dao.DepartmentDao;
import com.swd.springboot.dao.EmployeeDao;
import com.swd.springboot.entities.Department;
import com.swd.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 获取所有的员工信息
     * 返回员工的列表页面
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String getEmpList(Model model){

        Collection<Employee> emps = employeeDao.getAll();

        model.addAttribute("emps",emps);

        return "emp/list";
    }

    /**
     * 获取部门信息
     * 返回添加员工信息页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddEmpPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }


    /**
     * 添加员工信息
     * 返回员工列表
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 根据员工id返回更新页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toUpdatePage(Model model, @PathVariable("id") Integer id){
        System.out.println("==>"+id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        return "emp/add";
    }


    /**
     * 更新员工信息
     * 返回员工列表
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println("updateEmp=>"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){

        System.out.println("当前要删除员工的id==>"+id);
        employeeDao.delete(id);

        return "redirect:/emps";
    }




}
