package com.cccase.casebackend.mapper;

import com.cccase.casebackend.pojo.Accessories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccase.casebackend.pojo.vo.AccessoriesVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_accessories】的数据库操作Mapper
* @createDate 2023-10-14 14:58:55
* @Entity com.cccase.casebackend.pojo.Accessories
*/
@Mapper
public interface AccessoriesMapper extends BaseMapper<Accessories> {

    List<AccessoriesVo> getCaseAccessoriesById(@Param("caseId") Integer caseId);

    List<AccessoriesVo> getAccsByRRId(@Param("id") Integer id);
}




