package com.chendys.webbackend.filter;

import com.alibaba.fastjson2.JSON;
import com.chendys.webbackend.pojo.Admin;
import com.chendys.webbackend.pojo.vo.AdminVo;
import com.chendys.webbackend.pojo.vo.LoginUserVo;
import com.chendys.webbackend.service.RedisService;
import com.chendys.webbackend.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.lang.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

            AdminVo user = JSON.parseObject(JSON.toJSONString(claims.get("admin")), AdminVo.class);

            List<String> permissions = (List<String>) claims.get("permissions");

            if(!subject.equals(user.getName())){
                throw new RuntimeException("token非法");
            }

            String testString = (String) redisService.get("admin:" + user.getId());

            if(!token.equals(testString)){
                throw new RuntimeException("未登录");
            }

            request.setAttribute("adminId", user.getId());


            Admin admin = new Admin();
            admin.setPassword("");
            admin.setAccount(user.getAccount());
            admin.setEmail(user.getEmail());
            admin.setId(user.getId());
            admin.setImgUrl(user.getImgUrl());
            admin.setName(user.getName());
            admin.setPhone(user.getPhone());

            LoginUserVo loginUser = new LoginUserVo(admin, permissions);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            filterChain.doFilter(request,response);

        } else {
            throw new RuntimeException("token非法");
        }

    }


}
