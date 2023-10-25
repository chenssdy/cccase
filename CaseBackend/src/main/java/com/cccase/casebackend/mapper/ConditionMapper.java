package com.cccase.casebackend.mapper;

import com.cccase.casebackend.pojo.Condition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_condition】的数据库操作Mapper
* @createDate 2023-10-15 18:53:08
* @Entity com.cccase.casebackend.pojo.Condition
*/
@Mapper
public interface ConditionMapper extends BaseMapper<Condition> {

    List<Condition> getConditionByRRId(@Param("id") Integer id);
}




