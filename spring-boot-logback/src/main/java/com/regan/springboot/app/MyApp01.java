package com.regan.springboot.app;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.regan.springboot.model.entity.Foo;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@className: MyApp01
 *@description:
 *@author: weida.shi
 *@date: 2019/12/16 11:28
 *@version: V1.0
 **/
public class MyApp01 {
    public static final Logger LOGGER = LoggerFactory.getLogger(MyApp01.class);

    public static void main(String[] args) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);
        LOGGER.info("entering application");
        Foo foo = new Foo();
        foo.doit();
        LOGGER.info("exiting application");
    }
}