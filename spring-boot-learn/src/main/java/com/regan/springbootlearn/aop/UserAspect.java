package com.regan.springbootlearn.aop;

import com.regan.springbootlearn.bean.User;
import com.regan.springbootlearn.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *@className: UserAspect
 *@description:
 *@author: weida.shi
 *@date: 2019/11/12 22:22
 *@version: V1.0
 **/
@Aspect
@Component
public class UserAspect {
    public UserAspect() {
        System.out.println("###############userAspect");
    }

    @Value("${com.regan.eseId}")
    private Long eseId;
    @Pointcut("@annotation(initUser)")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("before");
        Method method = User.class.getMethod("setEseId", Long.class);
        User user = new User();
        method.invoke(user,eseId);
        System.out.println("========"+user);
    }

}