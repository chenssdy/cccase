package com.chendys.webbackend.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 积分兑换饰品请求类
 */
@Data
public class IntegralExchangeDto implements Serializable {

    /**
     * 饰品id
     */
    private Integer accessoriesId;

    /**
     * 库存余量
     */
    private Integer stock;

    /**
     * 状态(1.可兑换, 2.补货中,3.无库存)
     */
    private Integer status;
}
