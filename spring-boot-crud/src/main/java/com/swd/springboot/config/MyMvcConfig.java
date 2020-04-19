package com.swd.springboot.config;

import com.swd.springboot.component.LoginHandlerInterceptor;
import com.swd.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置类,配置自己的组件,使用WebMvcConfigurer来扩展SpringMvc的功能
@Configuration
//@EnableWebMvc  //该注解使得自动配置的springmvc失效,所有的操作都是又自己手动配置
public class MyMvcConfig implements WebMvcConfigurer {


    //配置自己的webmvc配置
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {

            /**
             * 添加视图映射
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 添加自定义的拦截器,排除一些不需要拦截的请求(包括静态资源)
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/", "/index.html", "/user/login", "/static/**", "/asserts/**", "/webjars/**");
            }
        };
        return webMvcConfigurer;
    }

    /**
     * 加载自定义的国际化解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
