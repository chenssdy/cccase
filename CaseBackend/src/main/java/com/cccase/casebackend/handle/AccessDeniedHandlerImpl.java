package com.cccase.casebackend.handle;

import com.alibaba.fastjson.JSON;
import com.cccase.casebackend.util.Result;
import com.cccase.casebackend.util.ResultEnum;
import com.cccase.casebackend.util.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result<Object> result = Result.instance(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getMessage(), null);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}
