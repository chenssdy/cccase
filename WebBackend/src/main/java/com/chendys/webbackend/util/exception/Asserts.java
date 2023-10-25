package com.chendys.webbackend.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenssdy
 * @description 业务异常抛出
 * @createDate 2022-11-20 16:18
 */
public class Asserts {

    private static final Logger logger = LoggerFactory.getLogger(Asserts.class);

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void auth(String message) {
        throw new AuthException(message);
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
