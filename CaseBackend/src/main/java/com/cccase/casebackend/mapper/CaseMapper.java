package com.cccase.casebackend.mapper;

import com.cccase.casebackend.pojo.Case;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chens
* @description 针对表【tb_case】的数据库操作Mapper
* @createDate 2023-10-14 14:58:55
* @Entity com.cccase.casebackend.pojo.Case
*/
@Mapper
public interface CaseMapper extends BaseMapper<Case> {

}




