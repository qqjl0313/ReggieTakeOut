package com.qqjl.reggie.common;

/**
 * 自定义业务异常
 *
 * @author QQJL
 * @since 2022/4/20 20:28
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
