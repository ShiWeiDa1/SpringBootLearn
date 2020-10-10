package com.swd.springboot.controller;

import com.swd.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(@RequestParam("user") String user) {

        // 请求参数 user 是aaa,则抛出用户不存在的异常
        if ("aaa".equals(user)) {
            throw new UserNotExistException();
        }

        return "hello";
    }

}
