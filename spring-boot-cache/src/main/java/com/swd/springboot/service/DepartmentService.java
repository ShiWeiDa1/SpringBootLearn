package com.swd.springboot.service;

import com.swd.springboot.bean.Department;
import com.swd.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author swd
 */
@Service
@CacheConfig(cacheNames = "dept", cacheManager = "departmentCacheManager")
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 代码方式编写缓存需要注入RedisCacheManager;
     */
    @Autowired
    RedisCacheManager departmentCacheManager;
    /*
    @Cacheable
    public Department getDepartmentById(Integer id){
        System.out.println("DepartmentService");
        Department deptById = departmentMapper.getDeptById(id);
        return  deptById;
    }*/

    /**
     * 编码方式编写缓存,使用缓存管理器得到缓存操作
     * @param id
     * @return
     */
    public Department getDepartmentById(Integer id) {
        Department deptById = departmentMapper.getDeptById(id);
        //获取某一个缓存
        Cache dept = departmentCacheManager.getCache("dept");
        dept.put("dept:1", deptById);
        return deptById;
    }
}
