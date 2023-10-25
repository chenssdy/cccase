package com.chendys.webbackend.pojo.vo;

import com.chendys.webbackend.pojo.CaseSales;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CaseSalesVo extends CaseSales {

    private String name;
}
