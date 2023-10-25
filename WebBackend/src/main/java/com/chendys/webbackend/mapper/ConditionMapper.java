package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.Condition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_condition】的数据库操作Mapper
* @createDate 2023-06-04 13:53:37
* @Entity com.chendys.webbackend.pojo.Condition
*/
@Mapper
public interface ConditionMapper extends BaseMapper<Condition> {

    List<Condition> selectRollRoomConditions(@Param("rid") Integer id);

}




