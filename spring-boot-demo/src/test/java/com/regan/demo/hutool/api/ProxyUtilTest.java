package com.regan.demo.hutool.api;

import com.regan.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *@className: ProxyUtilTest
 *@description:
 *@author: Regan
 *@date: 2020/11/17 23:52
 *@version: V1.0
 **/
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class ProxyUtilTest {
    @Test
    private void test01() {
        System.out.println("start...");
    }
}
