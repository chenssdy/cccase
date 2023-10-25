package com.chendys.webbackend.pojo.vo;

import com.chendys.webbackend.pojo.Accessories;
import com.chendys.webbackend.pojo.IntegralExchange;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 积分兑换饰品返回类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class IntegralExchangeVo extends IntegralExchange implements Serializable {

    /**
     * 饰品类
     */
    private Accessories accessories;

    public IntegralExchangeVo(IntegralExchange integralExchange){
        super(integralExchange.getId(), integralExchange.getAccessoriesId(), integralExchange.getStock(), integralExchange.getStatus(), integralExchange.getUpdateTime(), integralExchange.getUpdateTime());
    }

}