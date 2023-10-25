package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.IntegralExchange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendys.webbackend.pojo.dto.IntegralExchangeDto;
import com.chendys.webbackend.pojo.vo.IntegralExchangeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_integral_exchange】的数据库操作Mapper
* @createDate 2023-06-06 14:25:58
* @Entity com.chendys.webbackend.pojo.IntegralExchange
*/
@Mapper
public interface IntegralExchangeMapper extends BaseMapper<IntegralExchange> {


    List<IntegralExchangeVo> getPage(@Param("offset") Integer offset, @Param("num") Integer num, @Param("status") Integer status);

    int addIE(@Param("dto") IntegralExchangeVo dto);
}




