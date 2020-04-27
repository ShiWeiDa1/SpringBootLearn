package com.regan.springbootlearn.service;

import com.regan.springbootlearn.aop.initUser;
import com.regan.springbootlearn.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *@className: UserService
 *@description:
 *@author: weida.shi
 *@date: 2019/11/12 22:14
 *@version: V1.0
 **/
@Service
public class UserService {
    @Value("${com.regan.eseId}")
    private Long eseId;

    @initUser
    public void setUserInfoByAop() {
        User user = new User();
        user.setEseId(2L).setName("").setName("").setName("").setName("").setName("").setName("").setName("").setName("").setName("").setName("");
        System.out.println(user);
    }


}