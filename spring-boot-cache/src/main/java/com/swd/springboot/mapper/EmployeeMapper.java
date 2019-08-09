package com.swd.springboot.mapper;

import com.swd.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author swd
 */
@Mapper
@Repository
public interface EmployeeMapper {

    /**
     * 根据员工编号获取员工信息
     * @param id
     * @return
     */
    @Select("select * from employee")
    public Employee getEmpById(Integer id);

    /**
     * 更新员工信息
     * @param employee
     */
    @Update("update employee set lastName = #{lastName},email=#{email},gender=#{gender},d_id = #{dId} where id = #{id}")
    public void updateEmp(Employee employee);

    /**
     * 根据员工编号删除员工
     * @param id
     */
    @Delete("delete from employee where id = #{id}")
    public void delEmpById(Integer id);

    /**
     * 插入员工
     * @param employee
     */

    @Insert("insert into employee (lastName,email,gender,d_id)values (#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    /**
     * 根据用户名获取员工信息
     * @param lastName
     * @return
     */
    @Select("select * from employee where lastName=#{lastName}")
    Employee getEmpByLastName(String lastName);
}
