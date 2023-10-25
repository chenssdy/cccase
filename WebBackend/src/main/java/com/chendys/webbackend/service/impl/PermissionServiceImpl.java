package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.Permission;
import com.chendys.webbackend.service.PermissionService;
import com.chendys.webbackend.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author chens
* @description 针对表【tb_permission】的数据库操作Service实现
* @createDate 2023-05-30 18:11:40
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




