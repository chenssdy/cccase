package com.cccase.casebackend.pojo.vo;

import com.cccase.casebackend.pojo.IntegralExchange;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class IntegralExchangeVo extends IntegralExchange implements Serializable {


    private AccessoriesVo accessoriesVo;

}
