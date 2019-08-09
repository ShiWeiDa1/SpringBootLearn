package com.swd.springboot.service;

import com.swd.springboot.bean.Department;
import com.swd.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author swd
 */
@Service
@CacheConfig(cacheNames = "dept",cacheManager = "departmentCacheManager")
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;


    @Cacheable
    public Department getDepartmentById(Integer id){
        System.out.println("DepartmentService");
        Department deptById = departmentMapper.getDeptById(id);
        return  deptById;
    }
}
