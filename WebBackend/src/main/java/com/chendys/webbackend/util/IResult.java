package com.chendys.webbackend.util;

/**
 * @author chenssdy
 * @description 自定义统一返回数据结构接口
 * @createDate 2022-11-20 16:18
 */
public interface IResult {
    Integer getCode();
    String getMessage();
}
