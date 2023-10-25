package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chens
* @description 针对表【tb_admin】的数据库操作Mapper
* @createDate 2023-05-30 16:45:52
* @Entity com.chendys.webbackend.pojo.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}




