package com.chendys.webbackend.pojo.vo;

import com.chendys.webbackend.pojo.Condition;
import com.chendys.webbackend.pojo.RollRoom;
import com.chendys.webbackend.pojo.RollRoomParticipate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RollRoomVo extends RollRoom implements Serializable {

    /**
     * roll房参与条件列表
     */
    private List<Condition> conditions;


    /**
     * roll房参与成员列表
     */
    private List<RollRoomParticipate> rollRoomParticipates;
}
