package com.swd.springboot;

import com.swd.springboot.bean.Employee;
import com.swd.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 操作k-v都是字符串的
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 操作k-v对象
     */
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;

    /**
     * Redis常见的五大数据类型
     * String(字符串) list(列表) set(集合) zSet(有序集合) hash(散列)
     *         stringRedisTemplate.opsForValue();
     *         stringRedisTemplate.opsForList();
     *         stringRedisTemplate.opsForSet();
     *         stringRedisTemplate.opsForZSet();
     *         stringRedisTemplate.opsForHash();
     */
    @Test
    public void test01(){
        //stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    /**
     * 测试保存对象
     */
    @Test
    public void test02(){
        Employee emp = employeeMapper.getEmpById(1);
        //默认如果保存对象,使用jdk序列化机制,序列化后的数据保存到redis
        //redisTemplate.opsForValue().set("emp-01",emp);
        //1.将数据以json的方式保存
        //(1).自己将对象转为json
        //(2).redisTemplate默认的序列化规则 ;改变默认的序列化规则
        employeeRedisTemplate.opsForValue().set("emp-01",emp);
    }

    @Test
    public void contextLoads() {


    }

}
