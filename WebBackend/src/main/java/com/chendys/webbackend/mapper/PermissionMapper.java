package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_permission】的数据库操作Mapper
* @createDate 2023-05-30 18:11:40
* @Entity com.chendys.webbackend.pojo.Permission
*/
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    List<String> selectByAdminId(@Param("id") Integer id);
}




