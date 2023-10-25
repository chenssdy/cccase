package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.IntegralExchange;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cccase.casebackend.pojo.vo.IntegralExchangeVo;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_integral_exchange】的数据库操作Service
* @createDate 2023-10-15 11:33:37
*/
public interface IntegralExchangeService extends IService<IntegralExchange> {

    List<IntegralExchangeVo> getIEAccessories();

    Boolean exchange(Integer ieId);
}
