package com.regan.springbootresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringBootResttemplateApplicationTests {

    @Autowired
    private RestTemplate skipSslTemplate;

    @Test
    void contextLoads() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String str = "{\n" + "\t\"account\": \"qiaopai_isv\",\n" + "\t\"password\": \"qiaopai_isv123456\"\n" + "}";
        HttpEntity<String> objectHttpEntity = new HttpEntity<>(str, httpHeaders);
        ResponseEntity<String> exchange = skipSslTemplate.exchange(
                "https://wanduat.digitalshell.com.cn/api-gateway/data/isv/login/v1", HttpMethod.POST, objectHttpEntity,
                String.class);
        System.out.println(exchange.getBody());
    }

}
