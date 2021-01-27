package com.regan.alex.config;

import static com.regan.alex.constant.TheadNameConstant.SIMPLE_TASK;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.regan.alex.properties.ThreadPoolFactoryProperties;

import lombok.RequiredArgsConstructor;

/**
 *@className: WebAppConfig
 *@description:
 *@author: Regan
 *@date: 2021/1/6 22:01
 *@version: V1.0
 **/
@Configuration
public class WebAppConfig {

    private final ThreadPoolFactoryProperties threadPoolFactoryProperties;

    public WebAppConfig(ThreadPoolFactoryProperties threadPoolFactoryProperties) {
        this.threadPoolFactoryProperties = threadPoolFactoryProperties;
    }

    @Bean(SIMPLE_TASK)
    public TaskExecutor simpleThreadPoolTaskExecutor() {
        return buildExecutor(SIMPLE_TASK);
    }

    public ThreadPoolTaskExecutor buildExecutor(String taskName) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        /* 设置核心线程数 */
        threadPoolTaskExecutor.setCorePoolSize(threadPoolFactoryProperties.getCorePoolSize().getOrDefault(taskName,
                ThreadPoolFactoryProperties.DEFAULT_CORE_POOL_SIZE));
        /* 设置最大线程数 */
        threadPoolTaskExecutor.setMaxPoolSize(threadPoolFactoryProperties.getMaxPoolSize().getOrDefault(taskName,
                ThreadPoolFactoryProperties.DEFAULT_MAX_POOL_SIZE));
        /* 设置队列 */
        threadPoolTaskExecutor.setQueueCapacity(threadPoolFactoryProperties.getQueueCapacity().getOrDefault(taskName,
                ThreadPoolFactoryProperties.DEFAULT_QUEUE_CAPACITY));
        /* 设置最大空闲时间 */
        threadPoolTaskExecutor.setKeepAliveSeconds(threadPoolFactoryProperties.getKeepAliveSeconds().getOrDefault(taskName,
                ThreadPoolFactoryProperties.DEFAULT_KEEP_ALIVE_SECONDS));
        /* 设置线程前缀名称 */
        threadPoolTaskExecutor.setThreadNamePrefix(taskName);
        /* 设置等待任务在关机时完成,除非强制关机 */
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // threadPoolTaskExecutor.setRejectedExecutionHandler(new
        // ThreadPoolExecutor.DiscardPolicy());
        return threadPoolTaskExecutor;
    }
}
