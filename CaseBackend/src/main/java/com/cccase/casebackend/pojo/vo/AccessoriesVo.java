package com.cccase.casebackend.pojo.vo;

import com.cccase.casebackend.pojo.Accessories;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccessoriesVo extends Accessories implements Serializable {


    private String wearStr;

    private double probability;

    @Override
    public void setWear(Integer wear) {
        super.setWear(wear);

        String[] wears = {"崭新出厂", "略有磨损", "久经沙场", "破碎不堪", "战痕累累"};

        this.wearStr = wears[wear - 1];
    }

}
