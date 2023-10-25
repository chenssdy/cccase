package com.chendys.webbackend.service;

import com.chendys.webbackend.pojo.IntegralExchange;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chendys.webbackend.pojo.dto.IntegralExchangeDto;
import com.chendys.webbackend.pojo.vo.IntegralExchangeVo;
import com.chendys.webbackend.pojo.vo.Page;

/**
* @author chens
* @description 针对表【tb_integral_exchange】的数据库操作Service
* @createDate 2023-06-06 14:25:58
*/
public interface IntegralExchangeService extends IService<IntegralExchange> {


    /**
     * 获取一页积分兑换饰品数据
     * @param page
     * @param num
     * @param status 状态
     * @return
     */
    Page<IntegralExchangeVo> getPage(Integer page, Integer num, Integer status);


    /**
     * 创建可兑换饰品
     * @param integralExchangeDto
     * @return
     */
    IntegralExchangeVo addIE(IntegralExchangeDto integralExchangeDto);

    /**
     * 修改积分兑换数据
     * @param integralExchange
     * @return
     */
    IntegralExchangeVo updateIE(IntegralExchange integralExchange);


    /**
     * 删除积分兑换数据
     * @param id
     * @return
     */
    String deleteIE(Integer id);

}
