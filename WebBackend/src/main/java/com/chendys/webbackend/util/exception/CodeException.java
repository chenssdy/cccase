package com.chendys.webbackend.util.exception;

/**
 * @author chenssdy
 * @description 自定义验证码异常类
 * @createDate 2022-11-20 16:18
 */
public class CodeException extends Exception {

    public CodeException(String msg) {
        super(msg);
    }
}
