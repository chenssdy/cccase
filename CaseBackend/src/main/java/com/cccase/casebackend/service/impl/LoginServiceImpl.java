package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cccase.casebackend.mapper.UserMapper;
import com.cccase.casebackend.pojo.User;
import com.cccase.casebackend.pojo.dto.LoginDto;
import com.cccase.casebackend.pojo.vo.UserBackpackVo;
import com.cccase.casebackend.pojo.vo.UserVo;
import com.cccase.casebackend.service.LoginService;
import com.cccase.casebackend.service.RedisService;
import com.cccase.casebackend.util.JwtUtils;
import com.cccase.casebackend.util.exception.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public UserVo login(LoginDto dto) {

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(User::getAccount, dto.getAccount());

        User user = userMapper.selectOne(wrapper);

        if(Objects.isNull(user) || !user.getPassword().equals(dto.getPassword())){
            Asserts.args("用户名或者密码错误");
        }

        List<UserBackpackVo> userBackpackVos = userMapper.getUserAccs(user.getId());

        UserVo userVo = new UserVo(user);

        userVo.setUserBackpackVos(userBackpackVos);

        Map<String, Object> info = new HashMap<>();
        info.put("user", user);

        String token = new JwtUtils().createJwt(user.getName(), 60 * 1000 * 60 * 24 * 100, info);

        userVo.setToken(token);

        redisService.set("user:" + user.getId(), token);

        return userVo;
    }
}
