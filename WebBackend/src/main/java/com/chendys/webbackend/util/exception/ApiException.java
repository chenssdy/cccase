package com.chendys.webbackend.util.exception;

/**
 * @author chenssdy
 * @description 自定义Api异常类
 * @createDate 2022-11-20 16:20
 */
public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
