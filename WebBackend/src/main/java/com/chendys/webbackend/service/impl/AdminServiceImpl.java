package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.Admin;
import com.chendys.webbackend.service.AdminService;
import com.chendys.webbackend.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author chens
* @description 针对表【tb_admin】的数据库操作Service实现
* @createDate 2023-05-30 16:45:52
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




