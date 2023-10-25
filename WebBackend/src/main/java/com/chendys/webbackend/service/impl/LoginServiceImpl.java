package com.chendys.webbackend.service.impl;

import com.chendys.webbackend.mapper.MenuMapper;
import com.chendys.webbackend.pojo.Admin;
import com.chendys.webbackend.pojo.Menu;
import com.chendys.webbackend.pojo.vo.AdminVo;
import com.chendys.webbackend.pojo.vo.LoginUserVo;
import com.chendys.webbackend.service.LoginService;
import com.chendys.webbackend.service.RedisService;
import com.chendys.webbackend.util.JwtUtils;
import com.chendys.webbackend.util.SecurityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author chens
 * @description 后台登录接口实现类
 * @createDate 2023-05-30 16:45:52
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils = new JwtUtils();

    @Autowired
    private RedisService redisService;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public AdminVo login(Admin admin) {



        // 判断验证码
//        boolean codeCheckResult = validateCodeService.check(systemAdminLoginRequest.getKey(), systemAdminLoginRequest.getCode());
//        if (!codeCheckResult) throw new CrmebException("验证码不正确");
        // 用户验证
        Authentication authentication = null;
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getAccount(), admin.getPassword()));
        } catch (AuthenticationException e) {
//            if (e instanceof BadCredentialsException) {
//                throw new RuntimeException("用户不存在或密码错误");
//            }
//            throw new RuntimeException(e.getMessage());
            e.printStackTrace();
        }
        LoginUserVo loginUser = (LoginUserVo) authentication.getPrincipal();
        Admin admin_ = loginUser.getAdmin();
        AdminVo adminVo = new AdminVo(admin_.getId(), admin_.getName(), admin_.getEmail(), admin_.getPhone(), admin_.getAccount(), admin_.getImgUrl());

        Map<String, Object> info = new HashMap<>();
        info.put("admin", adminVo);
        info.put("permissions", loginUser.getPermissions());

        String token = new JwtUtils().createJwt(adminVo.getName(), 60 * 1000 * 60 * 24 * 10, info);

        adminVo.setToken(token);

        redisService.set("admin:" + adminVo.getId(), adminVo.getToken(), 60 * 1000 * 60 * 24 * 10);

        //更新最后登录信息
//        systemAdmin.setLoginCount(systemAdmin.getLoginCount() + 1);
//        systemAdmin.setLastIp(ip);
//        systemAdminService.updateById(systemAdmin);

        return adminVo;
    }

    @Override
    public AdminVo logout() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        LoginUserVo loginUser = (LoginUserVo) authentication.getPrincipal();
////        LoginUser loginUser = Transfrom.transToList(principal, LoginUser.class);
//        System.out.println(loginUser);
//        String id = loginUser.getUser().getId();
//        Boolean delete = redisTemplate.delete(id);
//        System.out.println(delete);

        return null;
    }

    @Override
    public List<Menu> getMenu() {

        LoginUserVo loginUserVo = SecurityUtil.getLoginUserVo();
        List<String> permissions = loginUserVo.getPermissions();

        List<Menu> menus = menuMapper.selectAdminMenu(permissions);

        return menus;
    }


    @Override
    public List<String> getPermission() {
        return SecurityUtil.getLoginUserVo().getPermissions();
    }
}
