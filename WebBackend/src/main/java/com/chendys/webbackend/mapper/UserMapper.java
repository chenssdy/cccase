package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendys.webbackend.pojo.vo.RollRoomVo;
import com.chendys.webbackend.pojo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2023-06-14 19:23:11
* @Entity com.chendys.webbackend.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserVo> getPage(@Param("offset") Integer offset, @Param("num") Integer num);
}




