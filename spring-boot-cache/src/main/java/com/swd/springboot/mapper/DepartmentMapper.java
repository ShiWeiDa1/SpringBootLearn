package com.swd.springboot.mapper;

import com.swd.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author swd
 */
@Repository
@Mapper
public interface DepartmentMapper {
    /**
     * 根据部门编号获取部门信息
     * @param id
     * @return
     */
    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);
}
