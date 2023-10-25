package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.UserRole;
import com.chendys.webbackend.service.UserRoleService;
import com.chendys.webbackend.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author chens
* @description 针对表【tb_user_role】的数据库操作Service实现
* @createDate 2023-05-30 18:11:40
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




