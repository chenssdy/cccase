package com.chendys.webbackend.util;

/**
 * @author chenssdy
 * @description 常用返回参数枚举
 * @createDate 2022-11-20 16:18
 */
public enum ResultEnum implements IResult {

    /**
     * 2 开头表示请求成功，但有可能没有权限，参数错误等
     */
    SUCCESS(2001, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    FORBIDDEN(2004, "没有权限访问资源"),
    REPEAT(2005, "重复操作"),
    /**
     * 3 开头表示需要重定向，可能是接口过期
     */
    // 接口过期
    API_EXPIRED(3001,"服务器繁忙,请稍后再试"),
    /**
     * 5 开头说明请求失败，可能是未登录或异常登录
     */
    // 业务报错
    SERVER_ERROR(5001, "服务器繁忙,请稍后再试"),
    // Token过期或被篡改
    TOKEN_ERROR(5002,"拉取用户登录状态失败，请重新登录"),
    // 未登录
    NO_LOGIN(5003,"您暂未登录");


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
