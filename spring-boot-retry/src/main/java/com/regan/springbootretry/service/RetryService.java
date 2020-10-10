package com.regan.springbootretry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 *@className: RetryService
 *@description: 重试机制服务层
 *@author: weida.shi
 *@date: 2019/11/5 15:53
 *@version: V1.0
 **/
@Service
@Slf4j
public class RetryService {
    @Retryable(value = Exception.class, backoff = @Backoff(delay = 500, multiplier = 2))
    public String retry() {
        // if (true) {
        // throw new RuntimeException();
        // }
        return "retry";
    }

    @Retryable(value = Exception.class, backoff = @Backoff(delay = 500, multiplier = 2))
    public String retry2() {
        if (true) {
            throw new RuntimeException();
        }
        return "retry";
    }

    /**
     *<pre>
     *  返回值要和被捕获异常方法的返回值一致,否则无法捕获异常
     *</pre>
     * @param e
     * @return
     */
    @Recover
    private String recover(RuntimeException e) {
        log.info("##  recover {} ##", e.getMessage());

        return "recover";
    }

}