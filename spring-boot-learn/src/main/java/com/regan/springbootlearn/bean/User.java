package com.regan.springbootlearn.bean;

import com.regan.springbootlearn.aop.initUser;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 *@className: User
 *@description:
 *@author: weida.shi
 *@date: 2019/11/12 22:12
 *@version: V1.0
 **/
@Data
@Accessors(chain = true)
@initUser
public class User implements Serializable {

    private static final long serialVersionUID = 7811044673179257914L;


    @Value("${com.regan.eseId}")
    private Long eseId;

    private String name;
}