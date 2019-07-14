package com.swd.springboot.exception;

/**
 * 自定义的用户不存在的异常
 */

public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
