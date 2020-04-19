package com.regan.springbootresttemplate.conf;

import com.regan.springbootresttemplate.http.SkipSslVerificationHttpRequestFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *@className: RestTemplateConfiguration
 *@description:
 *@author: Ty
 *@date: 2020/3/2 22:54
 *@version: V1.0
 **/
@Slf4j
@Configuration
public class RestTemplateConfiguration {
    /**
     * <pre>
     *     调用https请求时,跳过ssl的证书验证
     * </pre>
     * @return
     */
    @Bean
    public RestTemplate skipSslTemplate() {
        return new RestTemplate(new SkipSslVerificationHttpRequestFactory());
    }
}