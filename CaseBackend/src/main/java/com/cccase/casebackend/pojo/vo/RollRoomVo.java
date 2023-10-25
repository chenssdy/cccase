package com.cccase.casebackend.pojo.vo;

import com.cccase.casebackend.pojo.Condition;
import com.cccase.casebackend.pojo.RollRoom;
import com.cccase.casebackend.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RollRoomVo extends RollRoom implements Serializable {

    private List<AccessoriesVo> accessoriesVos;

    private List<Condition> conditions;

    private List<User> users;

}
