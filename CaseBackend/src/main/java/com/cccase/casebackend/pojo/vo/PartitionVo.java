package com.cccase.casebackend.pojo.vo;

import com.cccase.casebackend.pojo.Case;
import com.cccase.casebackend.pojo.Partition;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PartitionVo extends Partition implements Serializable {

    private List<Case> cases;


}
