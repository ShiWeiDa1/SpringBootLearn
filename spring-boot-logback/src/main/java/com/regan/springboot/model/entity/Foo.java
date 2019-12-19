package com.regan.springboot.model.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@className: Foo
 *@description:
 *@author: weida.shi
 *@date: 2019/12/16 11:29
 *@version: V1.0
 **/
public class Foo {
    public static final Logger LOGGER = LoggerFactory.getLogger(Foo.class);

    public void doit() {
        LOGGER.debug("Foo do it again");
    }
}