package com.swd.springboot.mapper;

import com.swd.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper {

    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    @Select("select * from department where id = #{id}")
    public Department getDepartmentById(Integer id);

    /**
     * 插入部门信息,自动生成主键的值
     * @param department
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department (departmentName) values (#{departmentName})")
    public int insertDepartment(Department department);

    /**
     * 根据部门id,删除部门信息
     * @param department
     * @return
     */
    @Delete("delete from department where id = #{id}")
    public int deleteDepartment(Department department);

    /**
     * 根据部门id更新部门的名称
     * @param department
     * @return
     */
    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public int updateDepartment(Department department);




}
