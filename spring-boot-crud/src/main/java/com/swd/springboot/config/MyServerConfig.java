package com.swd.springboot.config;

import com.swd.springboot.Servlet.MyServlet;
import com.swd.springboot.filter.Myfilter;
import com.swd.springboot.listenser.MyListenser;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;
import java.util.Arrays;

/**
 * 配置服务器相关的配置
 */
@Configuration
public class MyServerConfig {

    //注册三大组件: servlet,filter,listenser

    /**
     * 注册自定义的servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return servletRegistrationBean;
    }


    /**
     * 注册自定义的filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new Myfilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));


        return filterFilterRegistrationBean;

    }

    /**
     * 注册自定义的listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myServletListener() {
        ServletListenerRegistrationBean<MyListenser> registrationBean = new ServletListenerRegistrationBean<>(new MyListenser());
        return registrationBean;

    }

    /**
     * 配置Tomcat容器
     * Spring 2.xx WebServerFactoryCustomizer
     * Spring 1.xx Embeddedservletcontainercustomizer
     * 查看类的继承结构  ctr + h
     *
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            //定制嵌入式容器的相关规则
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                //设置端口号为
                factory.setPort(8080);
            }
        };
    }
}
