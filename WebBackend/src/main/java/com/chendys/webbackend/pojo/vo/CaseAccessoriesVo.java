package com.chendys.webbackend.pojo.vo;

import com.chendys.webbackend.pojo.Accessories;
import com.chendys.webbackend.pojo.CaseAccessories;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class CaseAccessoriesVo extends CaseAccessories {

    private Accessories accessories;
}
