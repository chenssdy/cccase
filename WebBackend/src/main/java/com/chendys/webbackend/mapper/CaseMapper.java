package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.Case;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendys.webbackend.pojo.vo.CaseVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author chens
* @description 针对表【tb_case】的数据库操作Mapper
* @createDate 2023-06-01 10:19:31
* @Entity com.chendys.webbackend.pojo.Case
*/
@Mapper
public interface CaseMapper extends BaseMapper<Case> {

    List<CaseVo> getPage(@Param("page") Integer page,@Param("num") Integer num);

    @MapKey("case_id")
    Map<String, Map<Integer, String>> selectAccIdByCaseId(@Param("ids") List<Integer> ids);
}




