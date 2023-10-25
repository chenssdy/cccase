package com.cccase.casebackend.mapper;

import com.cccase.casebackend.pojo.IntegralExchange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccase.casebackend.pojo.vo.IntegralExchangeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_integral_exchange】的数据库操作Mapper
* @createDate 2023-10-15 11:33:37
* @Entity com.cccase.casebackend.pojo.IntegralExchange
*/
@Mapper
public interface IntegralExchangeMapper extends BaseMapper<IntegralExchange> {

    List<IntegralExchangeVo> getIEAccessories();

}




