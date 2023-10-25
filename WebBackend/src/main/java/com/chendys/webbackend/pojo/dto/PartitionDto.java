package com.chendys.webbackend.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartitionDto implements Serializable {

    /**
     * 分区名称
     */
    private String name;

    /**
     * 分区排序
     */
    private Integer sort;
}
