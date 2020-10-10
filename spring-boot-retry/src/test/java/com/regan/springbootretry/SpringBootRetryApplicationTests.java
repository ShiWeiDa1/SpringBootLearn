package com.regan.springbootretry;

import com.regan.springbootretry.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringBootRetryApplicationTests {

    @Autowired
    private RetryService retryService;

    @Test
    void contextLoads() {
        retryService.retry2();
    }

}
