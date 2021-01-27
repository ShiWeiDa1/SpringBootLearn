package com.regan.alex.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 线程池配置参数
 * 
 * @author regan
 *
 */
@Component
@ConfigurationProperties(prefix = ThreadPoolFactoryProperties.THREAD_POOL_PREFIX)
public class ThreadPoolFactoryProperties {
    public static final String THREAD_POOL_PREFIX = "sao.aw.thread-pool";

    public static final Integer DEFAULT_CORE_POOL_SIZE = 10;

    public static final Integer DEFAULT_MAX_POOL_SIZE = 15;

    public static final Integer DEFAULT_QUEUE_CAPACITY = 5;

    public static final Integer DEFAULT_KEEP_ALIVE_SECONDS = 60;

    private Map<String, Integer> corePoolSize = new HashMap<>();

    private Map<String, Integer> maxPoolSize = new HashMap<>();

    private Map<String, Integer> queueCapacity = new HashMap<>();

    private Map<String, Integer> keepAliveSeconds = new HashMap<>();

    public Map<String, Integer> getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(Map<String, Integer> corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public Map<String, Integer> getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Map<String, Integer> maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Map<String, Integer> getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(Map<String, Integer> queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public Map<String, Integer> getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(Map<String, Integer> keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

}
