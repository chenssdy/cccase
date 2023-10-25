package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.CaseAccessories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendys.webbackend.pojo.vo.CaseAccessoriesVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_case_accessories】的数据库操作Mapper
* @createDate 2023-06-01 20:54:25
* @Entity com.chendys.webbackend.pojo.CaseAccessories
*/
@Mapper
public interface CaseAccessoriesMapper extends BaseMapper<CaseAccessories> {



    List<CaseAccessoriesVo> selectAccByCaseId(@Param("caseId") Integer caseId);
}




