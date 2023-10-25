package com.chendys.webbackend.handle;

import com.alibaba.fastjson.JSON;
import com.chendys.webbackend.util.Result;
import com.chendys.webbackend.util.ResultEnum;
import com.chendys.webbackend.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result<Object> result = Result.instance(ResultEnum.TOKEN_ERROR.getCode(), ResultEnum.TOKEN_ERROR.getMessage(), null);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}
