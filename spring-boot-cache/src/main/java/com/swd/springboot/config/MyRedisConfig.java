package com.swd.springboot.config;

import com.swd.springboot.bean.Department;
import com.swd.springboot.bean.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import sun.rmi.runtime.Log;

import java.net.UnknownHostException;
import java.time.Duration;

/**
 * @author swd
 */
@Configuration
public class MyRedisConfig {
    /**
     * 自定义empReids模板
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        System.out.println("empRedisTemplate...");
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisTemplate<Object, Department> departmentRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //jackson2的序列化器
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * CacheManagerCustomizers 来定制缓存的一些规则
     * @param redisConnectionFactory
     *
     * @return
     */
    @Bean
    @Primary
    public RedisCacheManager empCacheManager(RedisConnectionFactory redisConnectionFactory) {

        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<>(Employee.class);

        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                //设置持续时间
                .entryTtl(Duration.ofDays(1))
                //设置Jackson来序列化
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(configuration).build();

        return redisCacheManager;

    }

    @Bean
    public RedisCacheManager departmentCacheManager(RedisConnectionFactory redisConnectionFactory,
                                                    ResourceLoader resourceLoader) {
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<>(Department.class);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofDays(1))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));

        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(configuration).build();
        return redisCacheManager;
    }


}
