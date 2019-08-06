package com.swd.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author swd
 * 一、搭建基本环境
 * 1.导入数据库文件,创建department和employee表
 * 2.创建javabean封装数据
 * 3.整合MyBatis操作数据库
 *      1.配置数据源信息
 *      2.使用注解版的MyBatis
 *          1)使用@MapperScan来扫描指定Mapper接口的类
 *二、快速体验缓存
 *      步骤:
 *          1.开启基于注解的缓存@EnableCaching
 *          2.标注缓存注解即可
 *          @Cacheable
 *          @CacheEvict
 *          @CachePut
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache 将数据保存在 ConcurrentMap<Object, Object>
 * 开发中使用缓存中间件:redis,memcache,ehcache
 * 三、整合redis作为缓存
 * Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 *  1.安装redis
 *  2.引入redis的starter
 *  3.配置redis
 *  4.测试缓存
 *      原理:CacheManage==Cache缓存组件来实际给缓存中存取数据
 *          1.引入redis的starter,容器中保存的是ReidsCacheManager
 *          2.RedisCacheManager帮我们创建RedisCache来作为缓存组件 redisCache通过操作redis缓存数据
 *          3.默认保存数据k-v都是Object 利用序列化保存;如何自动的保存json
 *              1).引入了redis的starter,cacheManager变为RedisCacheManager;
 *
 */
@MapperScan("com.swd.springboot.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }

}