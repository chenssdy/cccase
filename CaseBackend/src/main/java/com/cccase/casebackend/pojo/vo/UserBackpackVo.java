package com.cccase.casebackend.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
public class UserBackpackVo implements Serializable {

    private Integer backpackId;

    private Integer status;

    private AccessoriesVo accessories;

}
