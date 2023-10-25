package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.CaseSales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendys.webbackend.pojo.vo.CaseSalesVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_case_sales】的数据库操作Mapper
* @createDate 2023-06-01 10:19:31
* @Entity com.chendys.webbackend.pojo.CaseSales
*/
@Mapper
public interface CaseSalesMapper extends BaseMapper<CaseSales> {

    List<CaseSalesVo> selectSalesTop();
}




