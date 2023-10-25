package com.cccase.casebackend.filter;

import com.alibaba.fastjson2.JSON;
import com.cccase.casebackend.pojo.User;
import com.cccase.casebackend.pojo.vo.LoginUserVo;
import com.cccase.casebackend.service.RedisService;
import com.cccase.casebackend.util.CaCheUtil;
import com.cccase.casebackend.util.JwtUtils;
import com.cccase.casebackend.util.exception.Asserts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.lang.Strings;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    public RedisService redisService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Token");
        if(!Strings.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }

        boolean jwt = jwtUtils.isJwt(token);

        if(jwt){
            Claims claims = jwtUtils.deJwt(token);

            String subject = claims.getSubject();

            User user = JSON.parseObject(JSON.toJSONString(claims.get("user")), User.class);

            if(!subject.equals(user.getName())){
                Asserts.token("token非法");
            }

            Object tokenO = redisService.get("user:" + user.getId());

            if(!token.equals(tokenO.toString())){
                Asserts.token("登录过期");
            }

            MDC.put("userId", String.valueOf(user.getId()));

            request.setAttribute("adminId", user.getId());

            LoginUserVo loginUser = new LoginUserVo(user, null);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            filterChain.doFilter(request,response);

        } else {
            Asserts.token("token非法");
        }

    }


}
