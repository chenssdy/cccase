package com.cccase.casebackend.handle;

import com.cccase.casebackend.util.Result;
import com.cccase.casebackend.util.ResultEnum;
import com.cccase.casebackend.util.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    /**
     * 业务异常拦截
     * @param rep
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public Object apiException(HttpServletResponse rep, Exception e){
        // Todo 通知开发
        log.error("业务异常：{}", e.getMessage());

        return Result.instance(ResultEnum.SERVER_ERROR.getCode(),ResultEnum.SERVER_ERROR.getMessage(),null);
    }

    /**
     * 用户登录状态异常
     * @param rep
     * @param e
     * @return
     */
    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public Object tokenException(HttpServletResponse rep, Exception e){
        // Todo 通知用户
        log.error("用户登录状态异常：{}", e.getMessage());

        return Result.instance(ResultEnum.TOKEN_ERROR.getCode(),ResultEnum.TOKEN_ERROR.getMessage(),null);
    }

    /**
     * 用户未登录
     * @param rep
     * @param e
     * @return
     */
    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public Object LoginException(HttpServletResponse rep, Exception e){

        log.warn("用户未登录：{}", e.getMessage());

        return Result.instance(ResultEnum.NO_LOGIN.getCode(),ResultEnum.NO_LOGIN.getMessage(),null);
    }

    /**
     * 验证码发送失败
     * @param rep
     * @param e
     */
    @ExceptionHandler(CodeException.class)
    public void CodeException(HttpServletResponse rep,Exception e){

        log.error("验证码发送失败： ==> " ,e);
    }

    /**
     * 参数校验失败
     * @param rep
     * @param e
     * @return
     */
    @ExceptionHandler(ArgsException.class)
    public Object ArgsException(HttpServletResponse rep,Exception e){

        log.info("用户参数错误： ==> {}" ,e.getMessage());
        return Result.instance(ResultEnum.VALIDATE_FAILED.getCode(), e.getMessage(),null);
    }

    /**
     * 该操作重复
     * @param rep
     * @param e
     * @return
     */
    @ExceptionHandler(RepeatException.class)
    @ResponseBody
    public Object RepeatException(HttpServletResponse rep,Exception e){

        log.warn("用户重复操作： ==> " ,e.getMessage());

        return Result.instance(ResultEnum.REPEAT.getCode(), e.getMessage(), null);
    }

    /**
     * 未知异常
     * @param rep
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exception(HttpServletResponse rep,Exception e){

        // Todo 通知开发
        log.error("发生未知异常： ==> " ,e);

        return Result.failed();
    }

}
