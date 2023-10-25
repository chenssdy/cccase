package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.RollRoom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendys.webbackend.pojo.vo.RollRoomVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_roll_room】的数据库操作Mapper
* @createDate 2023-06-04 12:41:05
* @Entity com.chendys.webbackend.pojo.RollRoom
*/
@Mapper
public interface RollRoomMapper extends BaseMapper<RollRoom> {

    List<RollRoomVo> getPage(@Param("page") Integer page, @Param("num") Integer num);
}




