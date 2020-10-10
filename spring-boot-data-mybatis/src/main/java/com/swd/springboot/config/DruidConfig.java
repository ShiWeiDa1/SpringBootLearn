package com.swd.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    // 导入Druid的pool
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource getDruid() {
        return new DruidDataSource();
    }

    // 1.注册状态视图servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParamters = new HashMap<>();
        initParamters.put("loginUsername", "admin");
        initParamters.put("loginPassword", "admin");
        initParamters.put("allow", "");
        bean.setInitParameters(initParamters);
        return bean;
    }

    // 2.注册过滤器
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParamters = new HashMap<>();
        initParamters.put("exclusions", "*.css,*.js,/druid/*");
        bean.setInitParameters(initParamters);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
