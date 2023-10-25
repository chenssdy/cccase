package com.cccase.casebackend.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Asserts {

    private static final Logger logger = LoggerFactory.getLogger(Asserts.class);

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void auth(String message) {
        throw new AuthException(message);
    }

    public static void token(String message){
        throw new TokenException(message);
    }

    public static void args(String message) {
        throw new ArgsException(message);
    }

    public static void Abnormal(String message) {
        // Todo
        // 通知开发
        logger.error(message);

        throw new ApiException("服务器繁忙,请稍后再试");
    }

    public static void warn(String message) {

        throw new RepeatException(message);
    }
}
