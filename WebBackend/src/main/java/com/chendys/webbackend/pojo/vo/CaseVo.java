package com.chendys.webbackend.pojo.vo;

import com.chendys.webbackend.pojo.Case;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CaseVo extends Case {

    private String partitionName;

    private long sales;

    private List<CaseAccessoriesVo> caseAccessoriesList;
}
