package com.swd.springboot.controller;

import com.swd.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义的异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 处理UserNotExistException的异常,返回自定义的json串
     * @return
     */
    /*
    1.这种方式没有自适应,都会返回json
    @ResponseBody  //json返回
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/


    //2.自适应返回错误页面
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        //查看ErrorMvcAutoConfiguration->BasicErrorController->AbstractErrorController(直接点击getStatus(request))
        //Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notExist");
        map.put("messages", "用户出错哦");

        //设置自己的状态码
        request.setAttribute("javax.servlet.error.status_code", 410);

        //在request域中添加自定义的信息
        request.setAttribute("ext", map);

        //转发到 /error
        return "forward:/error";
    }


}
