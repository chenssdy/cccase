package com.cccase.casebackend.handle;

import com.alibaba.fastjson.JSON;
import com.cccase.casebackend.util.Result;
import com.cccase.casebackend.util.ResultEnum;
import com.cccase.casebackend.util.WebUtils;
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
