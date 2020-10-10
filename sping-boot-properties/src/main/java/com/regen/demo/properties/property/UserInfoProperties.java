package com.regen.demo.properties.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *@className: UserInfoProperties
 *@description:
 *@author: weida.shi
 *@date: 2020/6/7 12:51
 *@version: V1.0
 **/
@ConfigurationProperties(prefix = "com.regan.user")
@Data
public class UserInfoProperties {
    private String name;
}