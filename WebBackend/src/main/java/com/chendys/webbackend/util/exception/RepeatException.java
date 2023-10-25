package com.chendys.webbackend.util.exception;

/**
 * @author chenssdy
 * @description 用户操作时该操作已经完成过一次了, 如添加已经存在的歌曲
 * @createDate 2022-11-20 16:20
 */
public class RepeatException extends RuntimeException {

    public RepeatException(String message) {
        super(message);
    }
}
