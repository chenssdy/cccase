package com.chendys.webbackend.util.exception;

/**
 * @author chenssdy
 * @description 自定义参数异常类
 * @createDate 2022-11-20 16:20
 */
public class ArgsException extends RuntimeException {
    public ArgsException(String message) {
        super(message);
    }
}
