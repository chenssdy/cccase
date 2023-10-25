package com.cccase.casebackend.mapper;

import com.cccase.casebackend.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccase.casebackend.pojo.vo.UserBackpackVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2023-10-14 20:24:06
* @Entity com.cccase.casebackend.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserBackpackVo> getUserAccs(@Param("userId") Integer userId);

    List<User> getUsersByRRId(@Param("id") Integer id);
}




