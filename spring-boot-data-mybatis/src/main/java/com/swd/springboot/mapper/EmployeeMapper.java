package com.swd.springboot.mapper;

import com.swd.springboot.bean.Employee;
import org.springframework.stereotype.Repository;

/**
 * @author swd
 */
@Repository
public interface EmployeeMapper {
    /**
     * 根据员工编号,查询员工信息
     * @param id 员工编号
     * @return
     */
    public Employee getEmployeeById(Integer id);

    /**
     * 插入员工信息
     * @param employee
     * @return
     */
    public int insertEmployee(Employee employee);
}
