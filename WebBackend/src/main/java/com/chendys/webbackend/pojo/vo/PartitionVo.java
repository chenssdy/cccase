package com.chendys.webbackend.pojo.vo;

import com.chendys.webbackend.pojo.Case;
import com.chendys.webbackend.pojo.Partition;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PartitionVo extends Partition implements Serializable {


    /**
     * 包含的盲盒
     */
    private List<Case> cases;
}
