package com.regan.springbootlearn.web;

import com.regan.springbootlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@className: UserController
 *@description:
 *@author: weida.shi
 *@date: 2019/11/12 22:38
 *@version: V1.0
 **/
@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public void setUserDefaultInfo(){

        userService.setUserInfoByAop();
    }
}