package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chendys.webbackend.mapper.AdminMapper;
import com.chendys.webbackend.mapper.PermissionMapper;
import com.chendys.webbackend.pojo.Admin;
import com.chendys.webbackend.pojo.vo.LoginUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getAccount, account);

        Admin admin = adminMapper.selectOne(wrapper);
        if(Objects.isNull(admin)){
            throw new RuntimeException("登录失败");
        }

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        List<String> list = permissionMapper.selectByAdminId(admin.getId());

        System.out.println(admin + "  " + list);
        return new LoginUserVo(admin, list);
    }
}
