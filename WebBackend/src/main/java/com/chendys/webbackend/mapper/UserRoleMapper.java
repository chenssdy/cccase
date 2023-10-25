package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chens
* @description 针对表【tb_user_role】的数据库操作Mapper
* @createDate 2023-05-30 18:11:40
* @Entity com.chendys.webbackend.pojo.UserRole
*/
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}




