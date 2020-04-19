package com.regan.springboot.test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.util.StatusPrinter;
import com.regan.springboot.util.LogbackCustomHostName;
import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.transform.Source;

/**
 *@className: LogBackTest
 *@description:
 *@author: weida.shi
 *@date: 2019/12/13 13:29
 *@version: V1.0
 **/

/**
 * 这个注解会初始化spring的容器
 */
// @SpringBootTest
public class LogBackTest {

    private static final Logger logger = LoggerFactory.getLogger(LogBackTest.class);

    @Test
    public void test01() {
        logger.debug("hello,world!");
    }

    /**
     * 获取日志的内部状态
     */
    @Test
    public void test02() {
        logger.debug("test 02");
        // 打印内部的状态
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        /**
         * 13:40:23.398 [main] DEBUG com.regan.springboot.test.LogBackTest - test 02
         * 13:40:23,334 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-spring.xml]
         * 13:40:23,334 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
         * 13:40:23,335 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.xml]
         * 13:40:23,340 |-INFO in ch.qos.logback.classic.BasicConfigurator@2df32bf7 - Setting up default configuration.
         */
        StatusPrinter.print(loggerContext);
    }

    /**
     * Test LogBackCustomHostName
     */
    @Test
    public void test03() {
        LogbackCustomHostName logbackCustomHostName = new LogbackCustomHostName();
        String propertyValue = logbackCustomHostName.getPropertyValue();
        // DESKTOP-5E6VDC9
        System.out.println(propertyValue);
    }

    /**
     * set logger level
     * ERROR > WARN > INFO > DEBUG >TRACE
     */
    @Test
    public void test04() {
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.regan");
        // set logger level
        logger.setLevel(Level.INFO);

        // warn > info level display
        // 15:01:12.047 [main] WARN com.regan - WARN
        logger.warn(Level.WARN.levelStr);

        // debug < info level no display
        logger.debug(Level.DEBUG.levelStr);

        // this loggerSon extends logger
        Logger loggerSon = LoggerFactory.getLogger("com.regan.son");

        // error > info level display
        // 15:01:12.053 [main] ERROR com.regan.son - ERROR
        loggerSon.error(Level.ERROR.levelStr);

        // trace < info level no display
        loggerSon.trace(Level.TRACE.levelStr);

    }

    public static void main(String[] args) {

    }

}