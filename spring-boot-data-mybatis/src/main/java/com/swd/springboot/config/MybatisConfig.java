package com.swd.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    /**
     * mybatis的自定义配置类
     * @return
     */
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                // 开启mybatis的驼峰命名法:如果采用配置文件的方式配置了全局mybatis配置文件,则失效
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
