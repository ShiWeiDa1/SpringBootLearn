package com.regan.demo.entity;

import java.io.Serializable;

/**
 *@className: UserDTO
 *@description:
 *@author: weida.shi
 *@date: 2020/8/3 21:24
 *@version: V1.0
 **/
public class UserDTO implements Serializable {


    private static final long serialVersionUID = 958278765829772876L;

    private String name;
    private Integer age;

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}