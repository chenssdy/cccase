package com.chendys.webbackend.util.exception;

/**
 * @author chenssdy
 * @description 自定义登录异常类
 * @createDate 2022-11-20 16:18
 */
public class LoginException extends Exception {

    static final long serialVersionUID = -7034897190745766939L;

    public LoginException(String s) {
        super(s);
    }
}
