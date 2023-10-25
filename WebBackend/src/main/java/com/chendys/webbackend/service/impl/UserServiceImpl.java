package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.User;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.RollRoomVo;
import com.chendys.webbackend.pojo.vo.UserVo;
import com.chendys.webbackend.service.UserService;
import com.chendys.webbackend.mapper.UserMapper;
import com.chendys.webbackend.util.exception.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-06-14 19:23:11
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<UserVo> getPage(Integer page, Integer num) {
        Page<UserVo> userPage = new Page<>(page, num);

        List<UserVo> rollRooms = userMapper.getPage(userPage.getOffset(), num);

        if(rollRooms.size() == 0){
            return null;
        }

        Integer integer = userMapper.selectCount(null);


        userPage.setList(rollRooms);
        userPage.setTotal(Long.valueOf(integer));
        userPage.setTotalPage(userPage.getTotalPage());


        return userPage;
    }

    @Override
    public Integer updateUserStatus(Integer userId, Integer status) {

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", userId).set("status", status);
        int update = userMapper.update(null, wrapper);

        if(update <= 0){
            Asserts.fail("修改失败，请联系管理员或者检查参数是否正确");
        }

        return status;
    }
}




