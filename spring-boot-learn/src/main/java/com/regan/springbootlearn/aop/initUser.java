package com.regan.springbootlearn.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Tom
 */
@Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface initUser {
}
