package com.swd.springboot.controller;

import com.swd.springboot.entity.User;
import com.swd.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author swd
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    /**
     * 插入用户数据
     * @param user
     * @return
     */
    @GetMapping(value = "/user")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable(value = "id") Integer id) {
        User user = userRepository.getOne(id);
        return user;
    }

}
