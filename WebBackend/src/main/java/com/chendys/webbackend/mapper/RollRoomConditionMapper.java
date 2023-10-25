package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.RollRoomCondition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_roll_room_condition】的数据库操作Mapper
* @createDate 2023-06-04 12:41:05
* @Entity com.chendys.webbackend.pojo.RollRoomCondition
*/
@Mapper
public interface RollRoomConditionMapper extends BaseMapper<RollRoomCondition> {

    int addAll(@Param("cids") List<Integer> conditionsId, @Param("rid") Integer id);
}




